package ejercicio9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class app {
    private static List<JToggleButton> cards = new ArrayList<>();
    private static List<Color> cardColors = new ArrayList<>();
    private static JToggleButton firstCard = null;
    private static JToggleButton secondCard = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 4));

        initializeCardColors();
        initializeCards();

        for (JToggleButton card : cards) {
            frame.add(card);
        }

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void initializeCardColors() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        Collections.shuffle(colors);

        cardColors.addAll(colors);
        cardColors.addAll(colors);
        Collections.shuffle(cardColors);
    }

    private static void initializeCards() {
        for (int i = 0; i < 16; i++) {
            JToggleButton card = new JToggleButton();
            card.setBackground(Color.GRAY);
            card.addActionListener(new CardClickListener());
            cards.add(card);
        }
    }

    private static class CardClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JToggleButton clickedCard = (JToggleButton) e.getSource();

            if (firstCard == null) {
                firstCard = clickedCard;
                firstCard.setBackground(cardColors.get(cards.indexOf(firstCard)));
                firstCard.setEnabled(false);
            } else if (secondCard == null && clickedCard != firstCard) {
                secondCard = clickedCard;
                secondCard.setBackground(cardColors.get(cards.indexOf(secondCard)));
                secondCard.setEnabled(false);

                if (cardColors.get(cards.indexOf(firstCard)).equals(cardColors.get(cards.indexOf(secondCard)))) {
                    firstCard = null;
                    secondCard = null;
                } else {
                    Timer timer = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            firstCard.setBackground(Color.GRAY);
                            secondCard.setBackground(Color.GRAY);
                            firstCard.setEnabled(true);
                            secondCard.setEnabled(true);
                            firstCard = null;
                            secondCard = null;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
}

