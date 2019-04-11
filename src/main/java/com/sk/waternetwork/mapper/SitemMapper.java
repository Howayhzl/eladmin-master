package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Site;
import com.sk.waternetwork.viewModel.CreateNameViewModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/3/28.
 */
@Component
public interface SitemMapper {
    public List<CreateNameViewModel> selectSiteByCondition(Site site);
}
