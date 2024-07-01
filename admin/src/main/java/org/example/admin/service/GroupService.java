package org.example.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.admin.dao.entity.GroupDO;
import org.example.admin.dto.req.GroupSortReqDTO;
import org.example.admin.dto.req.GroupUpdateReqDTO;
import org.example.admin.dto.res.GroupResDTO;

import java.util.List;

/**
 *
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * Add new short link group
     * @param groupName
     */
    void saveGroup(String groupName);

    /**
     * Get existing groups
     * @return
     */
    List<GroupResDTO> listGroup();

    void updateGroup(GroupUpdateReqDTO requestParam);

    void deleteGroup(String gid);

    void sortGroup(List<GroupSortReqDTO> requestParam);
}
