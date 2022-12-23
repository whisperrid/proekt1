import java.util.Scanner;

public class Main {
    private static String getCodingIncodMessage(String message, int key, char firstCharAlfabet, char lastCharAlfabet) {
        StringBuilder strBox = new StringBuilder(message.length()); //Стринг билдер так как много раз будет менятся буквенное значение
        char pos1;
        int countCharsAlfabet = (lastCharAlfabet - firstCharAlfabet) + 1;
        for (int i = 0; i < message.length(); i++) {
            pos1 = message.charAt(i);
            if (Character.isLetter(message.charAt(i))) {
                pos1 += key % countCharsAlfabet;
                if (pos1 > lastCharAlfabet)
                    pos1 = (char) (pos1 % lastCharAlfabet + firstCharAlfabet - 1);
                else if (pos1 < firstCharAlfabet)
                    pos1 = (char) (pos1 + countCharsAlfabet);
            }
            strBox.append(pos1);
        }
        return strBox.toString();
    }
    /*
        У меня не получалось все это красиво объеденить в один код, поэтому вывод написал через метод
        С помощью конструкции if-else сделал шифровку на разных языках (Eng, Rus)
        Сдвиг букв сделал на 14 позиций
        Используемая литература
        https://www.youtube.com/watch?v=dJuo7igM1v4
        https://javascopes.com/java-caesar-cipher-bbdeee8b/
        Немного информации с stackoverflow.com
        https://habr.com/ru/post/260767/
        https://3ty.ru/languages/java/sintaksis-yazyka-java
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите шифруемое слово");
        String message = scanner.nextLine();
        System.out.println("Какой язык вы используете: ");
        System.out.println("1 - Eng   2 - Rus");
        int yazik = scanner.nextInt();

        if (yazik == 1) {
            String codeMessage = getCodingIncodMessage(message, 14, 'a', 'z');
            System.out.println(message + " -> " + codeMessage);
        }
        else if (yazik == 2){
            String codeMessage = getCodingIncodMessage(message, 14, 'а', 'я');
            System.out.println(message + " -> " + codeMessage);
        }
    }
}
