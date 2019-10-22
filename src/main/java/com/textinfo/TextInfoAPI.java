package com.textinfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/textInfo")
public class TextInfoAPI {

    @GetMapping("/uppercaseLetter")
    public boolean isContainsUppercaseLetter(@RequestParam(name = "text") String text){
        boolean result = text.chars()
                .anyMatch(Character::isUpperCase);
        return result;
    }

    @GetMapping("/lowercaseLetter")
    public boolean isContainsLowercaseLetter(@RequestParam String text){
        boolean result = text.chars()
                .anyMatch(Character::isLowerCase);
        return result;
    }

    @GetMapping("/specialLetter")
    public boolean isContainsSpecialLetter(@RequestParam String text){
        long result = text.chars()
                .filter(value -> !Character.isDigit(value) && !Character.isLetter(value))
                .count();
        return result > 0;
    }

    @GetMapping("/numeric")
    public boolean isContainsNumeric(@RequestParam String text){
        boolean result = text.chars()
                .anyMatch(Character::isDigit);
        System.out.println(result);
        return result;
    }

    @GetMapping("/subsequence")
    public boolean isContainsUppercaseLetter(@RequestParam String text, @RequestParam String subsequence){
        System.out.println(text.contains(subsequence));
        return text.contains(subsequence);
    }
}
