import java.util.Scanner;

class CGPACalculator {
    public static void main(String[] args) {

        Scanner get = new Scanner(System.in);
        float totGPA = 0 ;
        float CGPA = 0;

        System.out.print("Enter the number of Semester : ");
        int n = get.nextInt();
        Semester[] semester = new Semester[n];

        System.out.println("Enter the Semester Grade and Cridits ");
        for (int i = 0; i < n; i++) {
            semester[i] = new Semester();
            System.out.print("Enter the subject Grade and Cridits for semster " + (i+1) + " :");
            semester[i].setSubjectsGradeCridits();
        }

        System.out.print("GPA For Every Semester"); 

        for (int i = 0; i < n; i++) {
            semester[i].totalCriditsAndPointXGrade();
            semester[i].calculateGPA();
            System.out.println("GPA for Semster " + (i+1) +" " + semester[i].gpa);
            totGPA = totGPA + semester[i].gpa;
        }

        CGPA = totGPA/n;

        System.out.println("CGPA for " + n +" Semester is :"+CGPA);

    }

}

class Semester {

    Scanner get = new Scanner(System.in);
    Subjects[] subjects = new Subjects[9];
    float gpa;
    float totalCridits = 0;
    float totalCriditXGrade = 0;
    int TotSubs = 9;
   
public void setSubjectsGradeCridits() {
    for (int i = 0; i < subjects.length; i++) {
        subjects[i] = new Subjects();
        System.out.print("Enter the Grade for subject " + (i+1) + ": ");
        String grade = get.nextLine().trim();
        if (grade.isEmpty()) {
            break;
        }
        char firstChar = grade.toUpperCase().charAt(0);

        if ((firstChar >= 'A' && firstChar <= 'F') || firstChar == 'S') {
            subjects[i].letterGrade = firstChar;
        } 
        else {
            System.out.println("Invalid input. Please enter a single character grade (A, B, C, D, E, F, S).");
            i--;
        } 
        System.out.println("Enter the Credits for subject " + (i+1) + ": ");
        subjects[i].criditPoint = get.nextInt();
        get.nextLine(); // Consume the newline character
    }
}

    public void totalCriditsAndPointXGrade(){

        for (int i = 0; i < TotSubs; i++) {
            totalCridits = totalCridits + subjects[i].criditPoint;
            totalCriditXGrade = totalCriditXGrade + subjects[i].calculateCriditXGrade();
        }

    }

    public void calculateGPA () {
        gpa = totalCriditXGrade/totalCridits;
    }
    
}

class Subjects {

    char letterGrade;
    float gradePoint;
    float criditPoint;
    float pointXGrade;
    
    
    public void gradePointConversion () {
            switch (letterGrade) {
                case 'S':
                    gradePoint = 10;
                    break;
                case 'A':
                    gradePoint = 9;
                    break;
                case 'B':
                    gradePoint = 8;
                    break;
                case 'C':
                    gradePoint = 7;
                    break;
                case 'D':
                    gradePoint = 6;
                    break;
                case 'E':
                    gradePoint = 5;
                    break;
                case 'F':
                    gradePoint = 0;
                    break;
                default:
                    gradePoint = 0;
                    break;
            }
    }
    
    public float calculateCriditXGrade () {
        gradePointConversion();
        return this.pointXGrade = this.gradePoint*this.criditPoint;
    }
    
}