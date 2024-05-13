package Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class CustomListCellRenderer extends DefaultListCellRenderer{
        private static final Color BACKGROUND_COLOR = new Color(230, 230, 250);
        private static final Color SELECTED_BACKGROUND_COLOR = new Color(135, 206, 250);
        private static final Color FOREGROUND_COLOR = Color.BLACK;

        public CustomListCellRenderer() {
            setOpaque(true);
            setBorder(new EmptyBorder(5, 10, 5, 10));
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Dostosowanie kolorów tła i czcionki
            if (isSelected) {
                renderer.setBackground(SELECTED_BACKGROUND_COLOR);
            } else {
                renderer.setBackground(BACKGROUND_COLOR);
            }

            renderer.setForeground(FOREGROUND_COLOR);

            return renderer;
        }
    }

