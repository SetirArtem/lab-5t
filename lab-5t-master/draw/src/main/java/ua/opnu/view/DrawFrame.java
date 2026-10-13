package ua.opnu.view;

import ua.opnu.model.DrawShape;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Головне вікно програми. Фрейм (клас JFrame) є контейнером верхнього рівня
 */
public class DrawFrame extends JFrame {

    // Область для малювання фігур
    private PaintSurface surface;

    public DrawFrame(String title) {
        super(title);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Додаємо верхню панель із кнопками
        this.add(setButtonPanel(), BorderLayout.NORTH);

        // Створюємо об'єкт області малювання
        surface = new PaintSurface();

        // Додаємо область для малювання фігур у фрейм
        this.add(surface, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    /*
     * Даний метод створює та налаштовує верхню панель із кнопками.
     */
    private JPanel setButtonPanel() {
        JPanel buttonPanel = new JPanel(true);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // 1. Кнопка для прямокутника
        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_RECTANGLE));
        buttonPanel.add(rect);

        // 2. Кнопка для закругленого прямокутника
        BigTextButton roundedRect = new BigTextButton("Rounded rect.");
        roundedRect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT));
        buttonPanel.add(roundedRect);

        // 3. Кнопка для еліпса
        BigTextButton ellipse = new BigTextButton("Ellipse");
        ellipse.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ELLIPSE));
        buttonPanel.add(ellipse);

        // 4. Кнопка "Clear" на додатковий бал
        BigTextButton clear = new BigTextButton("Clear");
        clear.addActionListener(e -> surface.clear());
        buttonPanel.add(clear);

        return buttonPanel;
    }
}