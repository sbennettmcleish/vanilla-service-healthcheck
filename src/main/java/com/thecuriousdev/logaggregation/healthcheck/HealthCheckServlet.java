/**
 * Created by SBM on 25/01/2018 11:52 PM.
 */
package com.thecuriousdev.logaggregation.healthcheck;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
@Slf4j
public class HealthCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setStatus(200);
            resp.setHeader("content-type", "application/json");
            resp.getWriter().append("Here you are!");
            log.debug("Hit /healthcheck");
        } catch (Exception e) {
            log.error("Couldn't write status to output stream", e);
            resp.setStatus(500);
        }
    }
}
