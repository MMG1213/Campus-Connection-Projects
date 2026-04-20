import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int marks;
    Student next;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.next = null;
    }
}

class StudentManagementSystem {
    static Student head = null;

    static void insert(int id, String name, int marks) {
        Student s = new Student(id, name, marks);
        s.next = head;
        head = s;
    }

    static void delete(int id) {
        Student temp = head, prev = null;
        while (temp != null) {
            if (temp.id == id) {
                if (prev == null) head = temp.next;
                else prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    static Student search(int id) {
        Student temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    static void sort() {
        for (Student i = head; i != null; i = i.next) {
            for (Student j = i.next; j != null; j = j.next) {
                if (i.marks < j.marks) {
                    int t = i.marks; i.marks = j.marks; j.marks = t;
                    String n = i.name; i.name = j.name; j.name = n;
                    int id = i.id; i.id = j.id; j.id = id;
                }
            }
        }
    }

    static void save() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
        Student temp = head;
        while (temp != null) {
            bw.write(temp.id + " " + temp.name + " " + temp.marks);
            bw.newLine();
            temp = temp.next;
        }
        bw.close();
    }

    static void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.marks);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Insert 2.Delete 3.Search 4.Sort 5.Display 6.Save 7.Exit");
            int ch = sc.nextInt();
            if (ch == 1) {
                insert(sc.nextInt(), sc.next(), sc.nextInt());
            } else if (ch == 2) {
                delete(sc.nextInt());
            } else if (ch == 3) {
                Student s = search(sc.nextInt());
                if (s != null)
                    System.out.println(s.id + " " + s.name + " " + s.marks);
                else
                    System.out.println("Not found");
            } else if (ch == 4) {
                sort();
            } else if (ch == 5) {
                display();
            } else if (ch == 6) {
                save();
            } else break;
        }
    }
}
