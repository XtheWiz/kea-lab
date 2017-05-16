package kealab.controller;

import kealab.domain.DummyModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xthewiz on 5/16/2017 AD.
 */
@RestController
public class ReportController {

    @Value("${targetJar}")
    String targetJar;

    @RequestMapping(value = "/report")
    public DummyModel makeReport(
            @RequestParam(value = "appId", required = false, defaultValue = "none") String appId) throws IOException {
        System.out.println("Target jar file : " + targetJar);
        System.out.println("App ID : " + appId);
        DummyModel dummyModel = new DummyModel();
        dummyModel.setId(1);

        List<String> cmdList = new ArrayList<>();
        cmdList.add("java");
        cmdList.add("-jar");
        cmdList.add(targetJar);
        if(!appId.equals("none")) {
            cmdList.add(appId);
        }

        List<String> respList = new ArrayList<>();

        ProcessBuilder processBuilder = new ProcessBuilder(cmdList);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = "";
        while ((s = reader.readLine()) != null) {
            respList.add(s);
        }
        dummyModel.setMessages(respList);

        System.out.println(dummyModel.getMessages());
        return dummyModel;

    }
}
