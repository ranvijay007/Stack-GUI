import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Stack{
    int top;
    ArrayList<Integer> value=new ArrayList<Integer>();
    Stack(){
        top=-1;
    }
    void push(int v){
        value.add(v);
        ++top;
    }
    String pop(){
        if(top == -1)
            return "Null";
        else
            return ""+value.get(top--);
    }
    String display(){
        int i=top;
        String str="";
        if(top == -1)
            return "->Null";
        else{
            while(i != -1){
                str=str+"->"+value.get(i--);
            }
            return str+"->Null";
        }
    }
}

class MainFrame extends JFrame{
    JPanel panel1,panel2,panel3;
    JTextField tf1,tf2;
    JTextArea ta;
    JButton btn1,btn2;
    Stack s;
    MainFrame(){
        s=new Stack();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        tf1=new JTextField(15);
        tf2=new JTextField(15);
        ta=new JTextArea(15, 30);
        JScrollPane sp=new JScrollPane(ta);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        btn1=new JButton("Push");
        btn2=new JButton("Pop");
        
        panel1.add(tf1);
        panel1.add(btn1);
        panel1.setLayout(new FlowLayout());
        
        panel2.add(sp,BorderLayout.CENTER);
        
        panel3.add(tf2);
        panel3.add(btn2);
        panel3.setLayout(new FlowLayout());
        
        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.SOUTH);
        ta.setEditable(false);
        tf2.setEditable(false);
        setVisible(true);
        setSize(400, 250);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tf1.getText().equals(""))
                    ta.setText(s.display());
                else{
                    int v=Integer.parseInt(tf1.getText());
                    s.push(v);
                    ta.setText(s.display());
                    tf1.setText("");
                }
                
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tf2.setText(s.pop());
                ta.setText(s.display());
            }
        });
    }
}
public class stackGUI {
    public static void main(String[] args) {
        new MainFrame();
    }
    
}
