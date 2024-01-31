package com.example.springbootsample.controller;

import com.example.springbootsample.dto.Person;
import com.example.springbootsample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:8082")
public class PersonController {

    @Autowired
    private PersonService personService;

    // 一覧：処理
//    @GetMapping("/list")
//    public String personList(Model model) {
//        model.addAttribute("persons", personService.retrieve());
//        return "/person/list";
//    }

    /*
    AppList.vueからの呼び出し、person一覧返却
     */
    @GetMapping("/list")
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> persons = personService.retrieve();
        return ResponseEntity.ok(persons);
    }

    // 詳細
//    @GetMapping
//    public String personSelect(@RequestParam("id") int id) {
//        return "redirect:/person/" + id;
//    }

    // 詳細：処理
//    @GetMapping("/{id}")
//    public String select(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personService.retrieve(id));
//        return "/person/person";
//    }

    /*
    AppList.vue id に該当するpersonの返却
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> select(@PathVariable("id") int id) {
        Person person = personService.retrieve(id);
        return ResponseEntity.ok(person);
    }

    // 登録
//    @GetMapping("/register")
//    public String returnRegisterPage() {
//        return "/person/register";
//    }

    // 登録：処理
//    @PostMapping ("/register/do")
//    public String personRegister(@ModelAttribute("person") Person person, Model model) {
//        personService.register(person);
//        model.addAttribute("persons", personService.retrieve());
//        model.addAttribute("message", "登録が完了しました。");
//        return "/person/list";
//    }

    /*
    AppList.vue 新規Person追加処理
     */
    @PostMapping("/register")
    public ResponseEntity<Person> registerPerson(@RequestBody Person person) {
        personService.register(person);
        return ResponseEntity.ok(person);
    }

    // 更新
//    @GetMapping("/update")
//    public String returnUpdatePage(Model model) {
//        model.addAttribute("persons", personService.retrieve());
//        return "/person/update";
//    }

    // 更新
//    @PostMapping("/update/do")
//    public String personUpdate(@ModelAttribute("person") Person person, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addAttribute("id", person.getId());
//        redirectAttributes.addFlashAttribute("person", person);
//        return "redirect:/person/update/" + person.getId();
//    }

    // 更新：処理
//    @GetMapping("/update/{id}")
//    public String update(@ModelAttribute("person") Person person, Model model) {
//        personService.update(person);
//        model.addAttribute("persons", personService.retrieve());
//        model.addAttribute("message", "更新が完了しました。");
//        return "/person/list";
//    }

    /*
    AppList.vue Person更新処理
     */
    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personService.update(person);
        return ResponseEntity.ok(person);
    }

    // 削除
//    @PostMapping("/delete/do")
//    public String personDelete(@RequestParam("id") int id) {
//        return "redirect:/person/delete/" + id;
//    }

    // 削除：処理
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id, Model model) {
//        personService.delete(id);
//        model.addAttribute("persons", personService.retrieve());
//        model.addAttribute("message", "削除が完了しました。");
//        return "/person/list";
//    }

    /*
    AppList.vue Person削除処理
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        personService.delete(id);
        return new ResponseEntity<>("削除が完了しました。", HttpStatus.OK);
    }
}
