package org.example.admin.remote.dto.req;

import cn.hutool.db.Page;
import lombok.Data;


@Data
public class ShortLinkPageReqDTO extends Page {
    private String gid;
}
