package pub.developers.forum.api.request.faq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaqSolutionRequest implements Serializable {

    private Long faqId;

    private Long commentId;

}
