package kr.or.connect.calculator.controller.api;

import io.swagger.annotations.*;
import kr.or.connect.calculator.dto.CalculatorResult;
import kr.or.connect.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/calculator")
public class CalculatorApiController {
    @Autowired
    private CalculatorService calculatorService;

    @ApiOperation(value = "덧셈 구하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping("/plus")
    public CalculatorResult plus(@RequestParam("value1")int value1, @RequestParam("value2") int value2){
        CalculatorResult calculatorResult = new CalculatorResult();
        calculatorResult.setValue1(value1);
        calculatorResult.setValue2(value2);
        calculatorResult.setOperation(CalculatorResult.PLUS_OPERATION);
        calculatorResult.setResult(calculatorService.plus(value1, value2));
        return calculatorResult;
    }

    @ApiOperation(value = "뺄셈 구하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping("/minus")
    public CalculatorResult minus(@RequestParam("value1")int value1, @RequestParam("value2") int value2){
        CalculatorResult calculatorResult = new CalculatorResult();
        calculatorResult.setValue1(value1);
        calculatorResult.setValue2(value2);
        calculatorResult.setOperation(CalculatorResult.MINUS_OPERATION);
        calculatorResult.setResult(calculatorService.minus(value1, value2));
        return calculatorResult;
    }
}