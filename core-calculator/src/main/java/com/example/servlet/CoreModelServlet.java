package com.example.servlet;

import com.example.util.CoreCalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculateCoreModel")
public class CoreModelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // Get the core model input (e.g., EE25/13/7)
            String coreModel = request.getParameter("coreModel");

            // Extract width, height, and depth from the core model
            String[] dimensions = coreModel.substring(2).split("/"); // Skip 'EE' part and split the remaining
            double width = Double.parseDouble(dimensions[0]);
            double height = Double.parseDouble(dimensions[1]);
            double depth = Double.parseDouble(dimensions[2]);

            // Create a calculator object using the parsed dimensions
            CoreCalculator calculator = new CoreCalculator(width, height, depth);

            // Perform the calculations
            double coreFactors = calculator.calculateCoreFactors();
            double effectiveVolume = calculator.calculateEffectiveVolume();
            double effectiveLength = calculator.calculateEffectiveLength();
            double effectiveArea = calculator.calculateEffectiveArea();
            double minimumArea = calculator.calculateMinimumArea();

            // Generate dynamic HTML response with calculation results
            out.println("<html>");
            out.println("<head><title>Calculation Results</title></head>");
            out.println("<body>");
            out.println("<h1>Calculation Results</h1>");
            out.println("<p>Core Factors: " + coreFactors + "</p>");
            out.println("<p>Effective Volume: " + effectiveVolume + " cubic mm</p>");
            out.println("<p>Effective Length: " + effectiveLength + " mm</p>");
            out.println("<p>Effective Area: " + effectiveArea + " square mm</p>");
            out.println("<p>Minimum Area: " + minimumArea + " square mm</p>");
            out.println("<a href=\"index.html\">Back to Calculator</a>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception e) {
            // Handle invalid input
            out.println("<html>");
            out.println("<head><title>Error</title></head>");
            out.println("<body>");
            out.println("<h1>Invalid Input</h1>");
            out.println("<p>Please enter the core model in the correct format (e.g., EE25/13/7).</p>");
            out.println("<a href=\"index.html\">Back to Calculator</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
