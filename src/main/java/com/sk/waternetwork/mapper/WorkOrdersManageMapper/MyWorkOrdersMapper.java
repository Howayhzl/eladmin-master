package com.sk.waternetwork.mapper.WorkOrdersManageMapper;

import com.sk.waternetwork.model.WorkOrders;
import com.sk.waternetwork.viewModel.CloseWorkOrdersViewModel;
import com.sk.waternetwork.viewModel.WorkOrdersViewModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/2/18.
 */
@Component
public interface MyWorkOrdersMapper {
    List<WorkOrdersViewModel> selectWorkOrdersByState(@Param("userCode")String userCode,@Param("companyCode")String companyCode,@Param("state")Integer state);
    int closeWorkOrders(CloseWorkOrdersViewModel closeWorkOrdersViewModel);

    int insertWorkOrders(WorkOrders workOrders);
    int updateWorkOrders(String code);



}



