package org.example.interview;

public class CHeckUniqueCharacter {

    public static void main(String[] args) {
        String input = "example string";
        char characterToCheck = 'v';

        boolean isUnique = isCharacterUnique(input, characterToCheck);
        System.out.println("Character '" + characterToCheck + "' is unique: " + isUnique);
    }

    public static boolean isCharacterUnique(String input, char character) {
        // Преобразуем строку в поток символов
        long count = input.chars()
                .filter(ch -> ch == character)
                .count();

        // Символ уникален, если встретился ровно один раз
        return count == 1;
    }
}
