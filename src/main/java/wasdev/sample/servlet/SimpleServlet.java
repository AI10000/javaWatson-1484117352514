package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		service.setUsernameAndPassword("328aaa11-efba-4646-97c2-2808241fca42", "Fjx1mQ2AQXZu");

		Classification classification = service.classify("ff1c34x160-nlc-3080","How hot will it be today?").execute();
		//System.out.println(classification);
        
        response.setContentType("text/html");
        response.getWriter().print(classification.top_class);
    }

}
