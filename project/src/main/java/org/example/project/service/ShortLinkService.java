package org.example.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.project.dao.entity.ShortLinkDO;
import org.example.project.dto.req.ShortLinkCreateReqDTO;
import org.example.project.dto.res.ShortLinkCreateResDTO;

public interface ShortLinkService extends IService<ShortLinkDO> {

    ShortLinkCreateResDTO createShortLink(ShortLinkCreateReqDTO requestParam);
}
