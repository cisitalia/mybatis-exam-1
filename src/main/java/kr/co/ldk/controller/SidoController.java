package kr.co.ldk.controller;

import kr.co.ldk.domain.Sido;
import kr.co.ldk.dto.SidoPageRequest;
import kr.co.ldk.dto.SidoPageResponse;
import kr.co.ldk.service.SidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sido")
@RequiredArgsConstructor
public class SidoController {
    
    private final SidoService sidoService;
    
    @GetMapping
    public String list(SidoPageRequest pageRequest, Model model) {
        SidoPageResponse response = sidoService.findPage(pageRequest);
        model.addAttribute("response", response);
        model.addAttribute("pageRequest", pageRequest);
        return "sido/list";
    }
    
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("sido", new Sido());
        return "sido/form";
    }
    
    @PostMapping("/create")
    public String create(@ModelAttribute Sido sido, RedirectAttributes redirectAttributes) {
        sidoService.save(sido);
        redirectAttributes.addFlashAttribute("message", "시도가 성공적으로 등록되었습니다.");
        return "redirect:/sido";
    }
    
    @GetMapping("/{seq}")
    public String detail(@PathVariable Integer seq, Model model) {
        Sido sido = sidoService.findById(seq);
        model.addAttribute("sido", sido);
        return "sido/detail";
    }
    
    @GetMapping("/{seq}/edit")
    public String editForm(@PathVariable Integer seq, Model model) {
        Sido sido = sidoService.findById(seq);
        model.addAttribute("sido", sido);
        return "sido/form";
    }
    
    @PostMapping("/{seq}/edit")
    public String edit(@PathVariable Integer seq, @ModelAttribute Sido sido, 
                       RedirectAttributes redirectAttributes) {
        sido.setSeq(seq);
        sidoService.update(sido);
        redirectAttributes.addFlashAttribute("message", "시도가 성공적으로 수정되었습니다.");
        return "redirect:/sido/" + seq;
    }
    
    @PostMapping("/{seq}/delete")
    public String delete(@PathVariable Integer seq, RedirectAttributes redirectAttributes) {
        sidoService.deleteById(seq);
        redirectAttributes.addFlashAttribute("message", "시도가 성공적으로 삭제되었습니다.");
        return "redirect:/sido";
    }
}