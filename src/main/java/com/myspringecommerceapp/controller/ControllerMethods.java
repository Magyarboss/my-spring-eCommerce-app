package com.myspringecommerceapp.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControllerMethods {

    protected static List<String> pageHistory = new ArrayList<>();


    /** ---- Finds the last url, adds it to pageHistory list (if its not null) and returns last url  ----
     *
     * @param request
     * @return
     */
    protected static Optional<String> getPreviousPageByRequestAndRedirect(HttpServletRequest request) {
        addPageToHistory(Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl).orElse(null));

        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }

    protected static List<String> addPageToHistory(String previousPage){
        if(previousPage != null) {
            pageHistory.add(previousPage);
        }
        return pageHistory;

    }

    protected static List<String> addPageToHistory(HttpServletRequest request){
        String previousPage = Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl).orElse(null);
        if(previousPage != null) {
            pageHistory.add(previousPage);
        }
        return pageHistory;

    }
}
