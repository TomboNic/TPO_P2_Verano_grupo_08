package org.example.ejercicio05.segundo.Implementacion;


import org.example.ejercicio05.segundo.Interfaces.Dictionary;

public class TextDecoder {

    /**
     * Recibe un String cifrado con el cifrado César y devuelve el texto desencriptado
     * utilizando la frecuencia de caracteres almacenada en un diccionario.
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1)
     *
     * @param cipherText Texto cifrado.
     * @return Texto desencriptado.
     */
    public String decode(String cipherText) {
        if (cipherText == null || cipherText.isEmpty()) {
            return "";
        }

        Dictionary frequencyDict = new DynamicDictionary();

        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) {
                int currentCount = 0;
                try {
                    currentCount = (int) frequencyDict.get(c);
                    frequencyDict.remove(c);
                } catch (Exception ignored) {}
                frequencyDict.add(c, currentCount + 1);
            }
        }

        char mostFrequentChar = 'e';
        int maxFrequency = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            try {
                int freq = (int) frequencyDict.get(c);
                if (freq > maxFrequency) {
                    maxFrequency = freq;
                    mostFrequentChar = c;
                }
            } catch (Exception ignored) {}
        }

        int shift = mostFrequentChar - 'e';

        StringBuilder decodedText = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char decodedChar = (char) (base + (c - base - shift + 26) % 26);
                decodedText.append(decodedChar);
            } else {
                decodedText.append(c);
            }
        }

        return decodedText.toString();
    }
}