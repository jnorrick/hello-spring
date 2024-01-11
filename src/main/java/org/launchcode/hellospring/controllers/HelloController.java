package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

// Responds to get requests at /hello?coder=LaunchCoder
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }


    @RequestMapping(method = {RequestMethod.GET}, value = "form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='german'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value ="hello", method = {RequestMethod.POST})
    public String helloPost(@RequestParam String name, @RequestParam String language ){
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("english")) {
            greeting = "Hello";
        }
        else if (language.equals("spanish")) {
            greeting = "Hola";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (language.equals("italian")) {
            greeting = "Ciao";
        }
        else if (language.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + name;
    }
}
