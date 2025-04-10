package ru.company.apiBilling.FNS.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.company.apiBilling.FNS.dto.FnsCheckResult;
import ru.company.apiBilling.FNS.jsonSerializeObject.StatResponse;
import ru.company.apiBilling.FNS.services.FnsService;

@RestController
@RequestMapping("/api/fns")
@RequiredArgsConstructor
public class FnsController {

    private final FnsService fnsService;


    @GetMapping("/checkInn")
    public FnsCheckResult getCompanyByINN(@RequestParam String inn, @RequestParam String key) {
        return fnsService.getByInn(inn, key);
    }

    @GetMapping("/stat")
    public StatResponse getStat( @RequestParam String key) {
        return fnsService.getStat(key);
    }



}
