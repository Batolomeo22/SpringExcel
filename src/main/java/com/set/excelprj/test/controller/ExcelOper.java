package com.set.excelprj.test.controller;

import com.set.excelprj.test.pojo.Result;
import com.set.excelprj.utils.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelOper {

    @RequestMapping(value = "/importFile", method = RequestMethod.POST)
    @ResponseBody
    public Result importFile(@RequestParam(value = "excelFile", required = false) MultipartFile file, HttpServletRequest request){
        try {
            MultipartRequest multipartRequest=(MultipartRequest) request;
            MultipartFile excelFile=multipartRequest.getFile("excelFile");

            if(excelFile!=null){
                List<List<String>> datas = new ArrayList<>();
                if (excelFile.getOriginalFilename().contains("xlsx")){
                    datas = ExcelUtils.readXlsx(excelFile.getInputStream());
                } else if (excelFile.getOriginalFilename().contains("xlsx")){
                    datas = ExcelUtils.readXls(excelFile.getInputStream());
                }

                //TODO: 读到的数据都在datas里面，根据实际业务逻辑做相应处理<br>                // .............
                if(datas!=null && datas.size()>0){
                    return new Result(true);
                }
            }else{
                return new Result(false);
            }
        } catch (Exception e) {
            return new Result(false,e.getMessage());
        }
        return new Result(false);

    }
}
