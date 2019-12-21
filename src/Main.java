import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        try{
            File f = new File("data.txt");
            if(!f.exists())
            {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
                out.writeObject(new Tester());
                out.close();
            }
        }
        catch (Exception e){}

        final int[] currentUser = new int[1];
        final int[] currentTest = new int[1];
        final int[] currentQuestion = {0};
        //<-----------ОКНО АВТОРИЗАЦИИ----------->
        JFrame frame = new JFrame("Main window");
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameText = new JTextField();
        JLabel loginLabel = new JLabel("Login:");
        JTextField loginText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JButton logButton = new JButton("Log in");
        JButton regButton = new JButton("Sign up");
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(10, 1));
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(loginLabel);
        panel.add(loginText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(logButton);
        panel.add(regButton);
        nameLabel.setVisible(false);
        nameText.setVisible(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(700, 300, 400, 300);
        frame.setVisible(true);
        //<-----------ОКНО АВТОРИЗАЦИИ----------->

        //<-----------ОКНО АДМИНИСТРАТОРА----------->
        JFrame AdmWin = new JFrame("im in");
        JButton checkResults = new JButton("Check user`s results");
        JButton addTest = new JButton("Add test");
        JButton addQuestion = new JButton("Add Question");
        JButton exitAdm = new JButton("Change user");
        JPanel AdmPanel = new JPanel();
        AdmPanel.setLayout(new GridLayout(4, 1));
        AdmWin.add(AdmPanel);
        AdmPanel.add(checkResults);
        AdmPanel.add(addTest);
        AdmPanel.add(addQuestion);
        AdmPanel.add(exitAdm);
        AdmWin.setBounds(700, 300, 250, 300);
        //<-----------ОКНО АДМИНИСТРАТОРА----------->

        //<-----------ОКНО ДОБАВЛЕНИЯ ТЕСТА----------->
        JFrame addTest_win = new JFrame("");
        JPanel addTest_panel = new JPanel();
        addTest_panel.setLayout(new GridLayout(3, 1));
        JLabel nameTest_lab = new JLabel("Name");
        JTextField nameTest = new JTextField();
        JButton admitTestName = new JButton("Admit");
        addTest_win.add(addTest_panel);
        addTest_panel.add(nameTest_lab);
        addTest_panel.add(nameTest);
        addTest_panel.add(admitTestName);
        addTest_win.setBounds(700, 300, 200, 150);
        //<-----------ОКНО ДОБАВЛЕНИЯ ТЕСТА----------->

        //<-----------ОКНО ДОБАВЛЕНИЯ ВОПРОСА----------->
        JFrame addQuestion_win = new JFrame("");
        ArrayList<String> listOftests = new ArrayList<>();
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
            Tester tester = (Tester)in.readObject();
            in.close();
            listOftests = tester.getTests();
        }
        catch (Exception e) {}
        final JComboBox listOfTests = new JComboBox(listOftests.toArray());
        JPanel addQuestion_panel = new JPanel();
        addQuestion_panel.setLayout(new GridLayout(14,1));
        JLabel Questionname_lab = new JLabel("Question");
        JTextField Questionname = new JTextField();
        JLabel insertanswers = new JLabel("Answers");
        JTextField insertansw1 = new JTextField();
        JTextField insertansw2 = new JTextField();
        JTextField insertansw3 = new JTextField();
        JTextField insertansw4 = new JTextField();
        ButtonGroup group = new ButtonGroup();
        JRadioButton insertransw1 = new JRadioButton("1");
        JRadioButton insertransw2 = new JRadioButton("2");
        JRadioButton insertransw3 = new JRadioButton("3");
        JRadioButton insertransw4 = new JRadioButton("4");
        group.add(insertransw1);
        group.add(insertransw2);
        group.add(insertransw3);
        group.add(insertransw4);
        JButton addQuestion_btn = new JButton("Add");
        addQuestion_win.add(addQuestion_panel);
        addQuestion_panel.add(listOfTests);
        addQuestion_panel.add(Questionname_lab);
        addQuestion_panel.add(Questionname);
        addQuestion_panel.add(insertanswers);
        addQuestion_panel.add(insertansw1);
        addQuestion_panel.add(insertansw2);
        addQuestion_panel.add(insertansw3);
        addQuestion_panel.add(insertansw4);
        addQuestion_panel.add(insertransw1);
        addQuestion_panel.add(insertransw2);
        addQuestion_panel.add(insertransw3);
        addQuestion_panel.add(insertransw4);
        addQuestion_panel.add(addQuestion_btn);
        addQuestion_win.setBounds(700, 300, 200, 300);
        //<-----------ОКНО ДОБАВЛЕНИЯ ВОПРОСА----------->

        //<-----------ОКНО ПОЛЬЗОВАТЕЛЯ----------->
        JFrame TestedUser = new JFrame("TestedUser");
        JPanel TestedUser_pan = new JPanel(new GridLayout(3, 1));
        TestedUser.add(TestedUser_pan);
        final JComboBox listOfTestsUser = new JComboBox(listOftests.toArray());
        JButton ConfirmTest = new JButton("Admit");
        JButton changeTestedUser = new JButton("Change user");
        TestedUser_pan.add(listOfTestsUser);
        TestedUser_pan.add(ConfirmTest);
        TestedUser_pan.add(changeTestedUser);
        TestedUser.setBounds(700, 300, 200, 150);
        //<-----------ОКНО ПОЛЬЗОВАТЕЛЯ----------->

        //<-----------ОКНО ПРОХОЖДЕНИЯ ТЕСТА----------->
        JFrame test = new JFrame();
        JPanel test_pan = new JPanel(new GridLayout(7, 1));
        test.add(test_pan);
        JLabel QuestionText = new JLabel();
        JLabel QuestionAnswers = new JLabel();
        JButton chooseAnswer = new JButton("Admit");
        ButtonGroup bgr = new ButtonGroup();
        JRadioButton ransw1 = new JRadioButton("1");
        JRadioButton ransw2 = new JRadioButton("2");
        JRadioButton ransw3 = new JRadioButton("3");
        JRadioButton ransw4 = new JRadioButton("4");
        bgr.add(ransw1);
        bgr.add(ransw2);
        bgr.add(ransw3);
        bgr.add(ransw4);
        test_pan.add(QuestionText);
        test_pan.add(QuestionAnswers);
        test_pan.add(ransw1);
        test_pan.add(ransw2);
        test_pan.add(ransw3);
        test_pan.add(ransw4);
        test_pan.add(chooseAnswer);
        test.setBounds(700, 300, 600, 300);
    //<-----------ОКНО ПРОХОЖДЕНИЯ ТЕСТА----------->

        //Кнопка "Выбрать ответ" в окне пользователя
        chooseAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ransw1.isSelected() || ransw2.isSelected() || ransw3.isSelected() || ransw4.isSelected())
                {
                    int ransw = -1;
                    if(ransw1.isSelected()) ransw = 1;
                    else if(ransw2.isSelected()) ransw = 2;
                    else if(ransw3.isSelected()) ransw = 3;
                    else if(ransw4.isSelected()) ransw = 4;
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                        Tester tester = (Tester) in.readObject();
                        in.close();
                        ArrayList<Question> questions = tester.tests.get(currentTest[0]).getQuestions();
                        tester.users.get(currentUser[0]).getAnswer(questions.get(currentQuestion[0]), ransw);
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
                        out.writeObject(tester);
                        out.close();
                        currentQuestion[0]+=1;
                        if(currentQuestion[0] == questions.size())
                        {
                            test.setVisible(false);
                            QuestionAnswers.setText("");
                            QuestionText.setText("");
                            TestedUser.setVisible(true);
                            currentQuestion[0] = 0;
                            currentTest[0] = 0;
                        }
                        else
                        {
                            QuestionText.setText(questions.get(currentQuestion[0]).getText());
                            QuestionAnswers.setText(String.join("\n", questions.get(currentQuestion[0]).getAnswers()));
                        }
                    } catch (Exception e1) {}
                }
            }
        });

        //Кнопка "Выбрать тест" в окне пользователя
        ConfirmTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTest[0] = listOfTestsUser.getSelectedIndex();
                TestedUser.setVisible(false);
                try
                {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                    Tester tester = (Tester) in.readObject();
                    in.close();
                    test.setTitle(tester.tests.get(currentTest[0]).getName());
                    ArrayList<Question> q = tester.tests.get(currentTest[0]).getQuestions();
                    QuestionText.setText(q.get(0).getText());
                    QuestionAnswers.setText(String.join("\n", q.get(0).getAnswers()));
                } catch(IOException e1) {}
                catch (ClassNotFoundException e1) {}
                test.setVisible(true);
            }
        });

        //Кнопка "Сменить пользователя" в окне пользователя
        changeTestedUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestedUser.setVisible(false);
                frame.setVisible(true);
            }
        });

        //Кнопка "Проверить результаты пользователей" в окне администратора
        checkResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                    Tester tester = (Tester) in.readObject();
                    in.close();
                    JOptionPane.showMessageDialog(null, String.join("\n", tester.getResults()));
                }
                catch(IOException e1) {System.out.println("Не читается");}
                catch(ClassNotFoundException e1) {System.out.println("класс не нашёлся");}
            }
        });

        //Кнопка "Добавить тест" в окне администратора
        addTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdmWin.setVisible(false);
                addTest_win.setVisible(true);
            }
        });

        //Кнопка "Подтвердить тест" в окне добавления теста
        admitTestName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!nameTest.getText().equals(""))
                {
                    try
                    {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                        Tester tester = (Tester) in.readObject();
                        in.close();
                        tester.addTest(new Test(nameTest.getText()));
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
                        out.writeObject(tester);
                        out.close();
                        listOfTests.addItem(nameTest.getText());
                        listOfTestsUser.addItem(nameTest.getText());
                        addTest_win.setVisible(false);
                        AdmWin.setVisible(true);
                    }
                    catch (IOException e1){System.out.println("файл похерился");}
                    catch (ClassNotFoundException e1) {System.out.println("класс не найден");}
                }
            }
        });

        //Кнопка "Добавить вопрос" в окне администратора
        addQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdmWin.setVisible(false);
                addQuestion_win.setVisible(true);
            }
        });

        //Кнопка "Добавить" на окне добавления вопроса в тест
        addQuestion_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listOfTests.getSelectedIndex();
                int ransw = -1;
                if(!Questionname.getText().equals("") &&
                        !insertansw1.getText().equals("") && !insertansw2.getText().equals("") && !insertansw3.getText().equals("") && !insertansw4.getText().equals("") &&
                        (insertransw1.isSelected() || insertransw2.isSelected() || insertransw3.isSelected() || insertransw4.isSelected()))
                {
                    if(insertransw1.isSelected()) ransw = 1;
                    else if(insertransw2.isSelected()) ransw = 2;
                    else if(insertransw3.isSelected()) ransw = 3;
                    else if(insertransw4.isSelected()) ransw = 4;
                    String[] tmp = {insertansw1.getText(), insertansw2.getText(), insertansw3.getText(), insertansw4.getText()};
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                        Tester tester = (Tester) in.readObject();
                        in.close();
                        tester.tests.get(index).addQuestion(new Question(Questionname.getText(), tmp, ransw));
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
                        out.writeObject(tester);
                        out.close();
                        Questionname.setText("");
                        insertansw1.setText("");
                        insertansw2.setText("");
                        insertansw3.setText("");
                        insertansw4.setText("");
                        AdmWin.setVisible(true);
                        addQuestion_win.setVisible(false);
                    } catch(Exception e1) {}
                }
            }
        });

        //Кнопка "Сменить пользователя" в окне администратора
        exitAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdmWin.setVisible(false);
                frame.setVisible(true);
            }
        });

        //Кнопка "Залогиниться" в окне авторизации
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if (!loginText.getText().equals("") && !passwordText.getText().equals("")) {
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                        Tester tester = (Tester) in.readObject();
                        in.close();
                        try {
                            currentUser[0] = tester.findUser(loginText.getText(), passwordText.getText());
                            if (tester.users.get(currentUser[0]).isAdmin()) {
                                frame.setVisible(false);
                                loginText.setText("");
                                passwordText.setText("");
                                AdmWin.setVisible(true); //Admin
                            }
                            else {
                                frame.setVisible(false);
                                loginText.setText("");
                                passwordText.setText("");
                                TestedUser.setVisible(true);
                            }
                        } catch (IllegalArgumentException I) {
                            JOptionPane.showMessageDialog(null, "There is no such user");
                        }
                    } catch (IOException e1) { System.out.println("КАВО НАХУЙ");}
                    catch (ClassNotFoundException e1) {}
                }
            }
        });

        //Кнопка "Зарегистрироваться" в окне авторизации
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameLabel.isVisible())
                {
                    try {
                        if (!nameText.getText().equals("") && !loginText.getText().equals("") && !passwordText.getText().equals("")) {
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
                            Tester tester = (Tester) in.readObject();
                            in.close();
                            tester.addUser(nameText.getText(), loginText.getText(), passwordText.getText());
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
                            out.writeObject(tester);
                            nameLabel.setVisible(false);
                            nameText.setVisible(false);
                            logButton.setVisible(true);
                            nameText.setText("");
                            loginText.setText("");
                            passwordText.setText("");
                            out.close();
                        }
                    }
                    catch (Exception io){}
                }
                else
                {
                    nameLabel.setVisible(true);
                    nameText.setVisible(true);
                    logButton.setVisible(false);
                }
            }
        });
    }
}
