package paixu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class SortingVisualizer extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    private static final int BAR_WIDTH = 30;
    // 数组元素的最大值
    private static final int MAX_VALUE = 1000;
    private static final int DELAY_MS = 1500;

    private int[] array;
    private int arraySize = 15;
    private JPanel sortingPanel;
    private JButton[] sortButtons;
    private JButton resetButton;
    private JButton randomizeButton;
    private JButton stopButton;
    private JTextField sizeField;
    private JTextField customArrayField;

    // 使用AtomicBoolean保证线程安全
    private AtomicBoolean isSorting = new AtomicBoolean(false);
    private AtomicBoolean shouldStop = new AtomicBoolean(false);

    // 可视化状态变量
    private int currentGap = -1;
    private int[] mergeRange = null;
    private int heapSize = -1;
    private int[] comparingIndices = {-1, -1};
    private int pivotIndex = -1;

    public SortingVisualizer() {
        setTitle("排序算法可视化");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeArray();
        initUI();
    }

    private void initializeArray() {
        array = new int[arraySize];
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(MAX_VALUE) + 10;
        }
        resetVisualizationState();
    }

    private void resetVisualizationState() {
        currentGap = -1;
        mergeRange = null;
        heapSize = -1;
        comparingIndices = new int[]{-1, -1};
        pivotIndex = -1;
    }

    private void initUI() {
        // 控制面板
        JPanel controlPanel = new JPanel(new GridLayout(2, 4, 5, 5));

        // 排序按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        String[] sortNames = {
                "冒泡排序", "选择排序", "插入排序",
                "希尔排序", "归并排序", "快速排序",
                "堆排序", "基数排序"
        };

        sortButtons = new JButton[sortNames.length];
        for (int i = 0; i < sortNames.length; i++) {
            sortButtons[i] = createStyledButton(sortNames[i]);
            sortButtons[i].addActionListener(new SortButtonListener(i));
            buttonPanel.add(sortButtons[i]);
        }

        // 控制按钮
        resetButton = createStyledButton("重置数组");
        resetButton.addActionListener(e -> {
            if (!isSorting.get()) {
                initializeArray();
                repaint();
            }
        });

        randomizeButton = createStyledButton("随机化数组");
        randomizeButton.addActionListener(e -> {
            if (!isSorting.get()) {
                Random rand = new Random();
                for (int i = 0; i < array.length; i++) {
                    array[i] = rand.nextInt(MAX_VALUE) + 10;
                }
                resetVisualizationState();
                repaint();
            }
        });

        stopButton = createStyledButton("停止排序");
        stopButton.setBackground(new Color(220, 20, 60)); // 红色按钮
        stopButton.addActionListener(e -> {
            if (isSorting.get()) {
                shouldStop.set(true);
            }
        });

        // 数组大小设置
        sizeField = new JTextField("15");
        sizeField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JButton sizeButton = createStyledButton("设置大小");
        sizeButton.addActionListener(e -> {
            if (!isSorting.get()) {
                try {
                    int newSize = Integer.parseInt(sizeField.getText());
                    if (newSize > 0 && newSize <= 30) {
                        arraySize = newSize;
                        initializeArray();
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(this, "请输入1-30之间的数字");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "请输入有效数字");
                }
            }
        });

        // 自定义数组
        customArrayField = new JTextField("输入逗号分隔的数字，如:5,3,8,1");
        customArrayField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JButton customArrayButton = createStyledButton("设置自定义数组");
        customArrayButton.addActionListener(e -> {
            if (!isSorting.get()) {
                try {
                    String[] parts = customArrayField.getText().split(",");
                    int[] newArray = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        newArray[i] = Integer.parseInt(parts[i].trim());
                        if (newArray[i] < 0 || newArray[i] > MAX_VALUE) {
                            JOptionPane.showMessageDialog(this, "数值应在0-" + MAX_VALUE + "之间");
                            return;
                        }
                    }
                    if (newArray.length > 30) {
                        JOptionPane.showMessageDialog(this, "数组长度不能超过30");
                        return;
                    }
                    array = newArray;
                    arraySize = array.length;
                    sizeField.setText(String.valueOf(arraySize));
                    resetVisualizationState();
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "请输入有效的数字，用逗号分隔");
                }
            }
        });

        // 添加组件到控制面板
        controlPanel.add(createLabelPanel("数组大小:", sizeField, sizeButton));
        controlPanel.add(createLabelPanel("自定义数组:", customArrayField, customArrayButton));
        controlPanel.add(randomizeButton);
        controlPanel.add(resetButton);
        controlPanel.add(stopButton);

        // 排序可视化面板
        sortingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (array == null) return;

                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int barWidth = Math.min(BAR_WIDTH, panelWidth / array.length - 2);

                // 绘制状态信息
                drawStatusInfo(g2d, panelWidth);

                // 绘制数组元素
                for (int i = 0; i < array.length; i++) {
                    int barHeight = (int) ((double) array[i] / MAX_VALUE * (panelHeight - 100));
                    int x = i * (barWidth + 2) + (panelWidth - array.length * (barWidth + 2)) / 2;
                    int y = panelHeight - barHeight - 50;

                    Color color = getBarColor(i);
                    g2d.setColor(color);
                    g2d.fillRect(x, y, barWidth, barHeight);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, barWidth, barHeight);

                    // 显示数值 - 改进的数字显示方式
                    if (array.length <= 20) {
                        String numStr = String.valueOf(array[i]);
                        g2d.setColor(Color.BLACK);


                            g2d.drawString(numStr, x + 2, y + 15);

                    }
                }
            }

            private Color getBarColor(int index) {
                // 比较中的元素
                if (index == comparingIndices[0] || index == comparingIndices[1]) {
                    return new Color(255, 215, 0); // 金色
                }

                // 快速排序的基准点
                if (index == pivotIndex) {
                    return new Color(220, 20, 60); // 红色
                }

                // 希尔排序的当前gap分组
                if (currentGap > 0 && index % currentGap == 0) {
                    return new Color(0, 191, 255); // 深天蓝
                }

                // 归并排序的范围
                if (mergeRange != null && index >= mergeRange[0] && index <= mergeRange[1]) {
                    if (index <= mergeRange[2]) { // 左半部分
                        return new Color(50, 205, 50); // 绿色
                    } else { // 右半部分
                        return new Color(255, 165, 0); // 橙色
                    }
                }

                // 堆排序的堆范围
                if (heapSize >= 0 && index < heapSize) {
                    return new Color(138, 43, 226); // 紫色
                }

                // 默认颜色
                return new Color(70, 130, 180); // 钢蓝色
            }

            private void drawStatusInfo(Graphics2D g2d, int panelWidth) {
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("微软雅黑", Font.BOLD, 14));

                int yPos = 20;
                if (currentGap > 0) {
                    g2d.drawString("希尔排序 - 当前间隔(gap): " + currentGap, 20, yPos);
                    yPos += 20;
                }
                if (mergeRange != null) {
                    g2d.drawString("归并排序 - 合并范围: " + mergeRange[0] + "到" + mergeRange[1] +
                            " (中点: " + mergeRange[2] + ")", 20, yPos);
                    yPos += 20;
                }
                if (heapSize >= 0) {
                    g2d.drawString("堆排序 - 当前堆大小: " + heapSize, 20, yPos);
                    yPos += 20;
                }
                if (pivotIndex >= 0) {
                    g2d.drawString("快速排序 - 基准点: " + array[pivotIndex] + " (索引: " + pivotIndex + ")", 20, yPos);
                    yPos += 20;
                }
                if (comparingIndices[0] >= 0) {
                    g2d.drawString("比较元素: 索引 " + comparingIndices[0] + " 和 " + comparingIndices[1], 20, yPos);
                    yPos += 20;
                }
                if (shouldStop.get()) {
                    g2d.setColor(Color.RED);
                    g2d.drawString("排序已停止", panelWidth - 100, 20);
                }
            }
        };
        sortingPanel.setBackground(new Color(240, 240, 240));

        // 添加组件到主窗口
        add(controlPanel, BorderLayout.NORTH);
        add(sortingPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

    private JPanel createLabelPanel(String labelText, JTextField textField, JButton button) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);
        return panel;
    }

    private class SortButtonListener implements ActionListener {
        private int sortType;

        public SortButtonListener(int sortType) {
            this.sortType = sortType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isSorting.get()) return;

            new Thread(() -> {
                isSorting.set(true);
                shouldStop.set(false);
                disableButtons();
                resetVisualizationState();
                repaint();

                try {
                    switch (sortType) {
                        case 0: bubbleSort(); break;
                        case 1: selectionSort(); break;
                        case 2: insertionSort(); break;
                        case 3: shellSort(); break;
                        case 4: mergeSort(); break;
                        case 5: quickSort(); break;
                        case 6: heapSort(); break;
                        case 7: radixSort(); break;
                    }
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    if (shouldStop.get()) {
                        initializeArray(); // 停止后重置数组
                    }
                    resetVisualizationState();
                    repaint();
                    isSorting.set(false);
                    shouldStop.set(false);
                    enableButtons();
                }
            }).start();
        }
    }

    private void disableButtons() {
        for (JButton button : sortButtons) {
            button.setEnabled(false);
        }
        resetButton.setEnabled(false);
        randomizeButton.setEnabled(false);
        sizeField.setEnabled(false);
        customArrayField.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void enableButtons() {
        for (JButton button : sortButtons) {
            button.setEnabled(true);
        }
        resetButton.setEnabled(true);
        randomizeButton.setEnabled(true);
        sizeField.setEnabled(true);
        customArrayField.setEnabled(true);
        stopButton.setEnabled(false);
    }

    private void repaintWithDelay() throws InterruptedException {
        if (shouldStop.get()) {
            throw new InterruptedException("排序被用户停止");
        }

        Thread.sleep(DELAY_MS);
        SwingUtilities.invokeLater(() -> sortingPanel.repaint());

        if (shouldStop.get()) {
            throw new InterruptedException("排序被用户停止");
        }
    }

    // ========== 排序算法实现 ==========

    private void bubbleSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                comparingIndices = new int[]{j, j + 1};
                repaintWithDelay();

                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    repaintWithDelay();
                }
            }
        }
        comparingIndices = new int[]{-1, -1};
    }

    private void selectionSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                comparingIndices = new int[]{minIndex, j};
                repaintWithDelay();

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    repaintWithDelay();
                }
            }

            if (minIndex != i) {
                swap(i, minIndex);
                repaintWithDelay();
            }
        }
        comparingIndices = new int[]{-1, -1};
    }

    private void insertionSort() throws InterruptedException {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            comparingIndices = new int[]{j, i};
            repaintWithDelay();

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                comparingIndices = new int[]{j, j + 1};
                repaintWithDelay();
                j--;
            }
            array[j + 1] = key;
            repaintWithDelay();
        }
        comparingIndices = new int[]{-1, -1};
    }

    private void shellSort() throws InterruptedException {
        for (currentGap = array.length / 2; currentGap > 0; currentGap /= 2) {
            repaintWithDelay();

            for (int i = currentGap; i < array.length; i++) {
                int temp = array[i];
                int j;

                for (j = i; j >= currentGap && array[j - currentGap] > temp; j -= currentGap) {
                    comparingIndices = new int[]{j, j - currentGap};
                    array[j] = array[j - currentGap];
                    repaintWithDelay();
                }

                array[j] = temp;
                repaintWithDelay();
            }
        }
        currentGap = -1;
        comparingIndices = new int[]{-1, -1};
    }

    private void mergeSort() throws InterruptedException {
        mergeRange = new int[3]; // 用于存储left, right, mid
        mergeSortHelper(0, array.length - 1);
        mergeRange = null;
    }

    private void mergeSortHelper(int left, int right) throws InterruptedException {
        if (left < right) {
            int mid = (left + right) / 2;

            // 显示分解过程
            mergeRange = new int[]{left, right, mid};
            repaintWithDelay();

            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);

            // 显示合并过程
            mergeRange = new int[]{left, right, mid};
            repaintWithDelay();

            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) throws InterruptedException {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            comparingIndices = new int[]{i, j};
            repaintWithDelay();

            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
            repaintWithDelay();
        }

        while (i <= mid) {
            temp[k++] = array[i++];
            repaintWithDelay();
        }

        while (j <= right) {
            temp[k++] = array[j++];
            repaintWithDelay();
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            array[i] = temp[k];
            repaintWithDelay();
        }

        comparingIndices = new int[]{-1, -1};
    }

    private void quickSort() throws InterruptedException {
        quickSortHelper(0, array.length - 1);
        pivotIndex = -1;
    }

    private void quickSortHelper(int low, int high) throws InterruptedException {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) throws InterruptedException {
        pivotIndex = high;
        repaintWithDelay();

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparingIndices = new int[]{j, pivotIndex};
            repaintWithDelay();

            if (array[j] < pivot) {
                i++;
                swap(i, j);
                repaintWithDelay();
            }
        }

        swap(i + 1, high);
        repaintWithDelay();

        comparingIndices = new int[]{-1, -1};
        pivotIndex = -1;
        return i + 1;
    }

    private void heapSort() throws InterruptedException {
        heapSize = array.length;

        // 构建最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            comparingIndices = new int[]{i, -1};
            heapify(heapSize, i);
        }

        // 一个个从堆顶取出元素
        for (int i = array.length - 1; i > 0; i--) {
            comparingIndices = new int[]{0, i};
            repaintWithDelay();

            swap(0, i);
            heapSize = i;
            repaintWithDelay();

            heapify(i, 0);
        }

        heapSize = -1;
        comparingIndices = new int[]{-1, -1};
    }

    private void heapify(int n, int i) throws InterruptedException {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparingIndices = new int[]{largest, left};
            repaintWithDelay();

            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparingIndices = new int[]{largest, right};
            repaintWithDelay();

            if (array[right] > array[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            comparingIndices = new int[]{i, largest};
            repaintWithDelay();

            swap(i, largest);
            repaintWithDelay();

            heapify(n, largest);
        }
    }

    private void radixSort() throws InterruptedException {
        int max = getMax();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp);
            repaintWithDelay();
        }
    }

    private int getMax() {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void countSort(int exp) throws InterruptedException {
        int[] output = new int[array.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;

            // 显示基数排序过程
            comparingIndices = new int[]{i, -1};
            repaintWithDelay();
        }

        System.arraycopy(output, 0, array, 0, array.length);
        repaintWithDelay();

        comparingIndices = new int[]{-1, -1};
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualizer visualizer = new SortingVisualizer();
            visualizer.setVisible(true);
        });
    }
}