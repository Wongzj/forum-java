package pub.developers.forum.domain.entity;

import lombok.*;
import pub.developers.forum.common.enums.AuditStateEn;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {

    private String groupName;


    private String name;


    private String description;


    private Long refCount;


    private Long creatorId;


    private AuditStateEn auditState;
}
