package org.example.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.example.project.dao.entity.ShortLinkDO;
import org.example.project.dto.req.ShortLinkCreateReqDTO;
import org.example.project.dto.req.ShortLinkUpdateReqDTO;
import org.example.project.dto.res.ShortLinkCreateResDTO;

import java.util.List;

public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateResDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 根据分布式锁创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateResDTO createShortLinkByLock(ShortLinkCreateReqDTO requestParam);

    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 批量创建短链接返回参数
     */
    ShortLinkBatchCreateResDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);

    /**
     * 修改短链接
     *
     * @param requestParam 修改短链接请求参数
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * 查询短链接分组内数量
     *
     * @param requestParam 查询短链接分组内数量请求参数
     * @return 查询短链接分组内数量响应
     */
    List<ShortLinkGroupCountQueryResDTO> listGroupShortLinkCount(List<String> requestParam);

    /**
     * 短链接跳转
     *
     * @param shortUri 短链接后缀
     * @param request  HTTP 请求
     * @param response HTTP 响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * 短链接统计
     *
     * @param shortLinkStatsRecord 短链接统计实体参数
     */
    void shortLinkStats(ShortLinkStatsRecordDTO shortLinkStatsRecord);
}
