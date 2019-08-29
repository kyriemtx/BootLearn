package com.example.demo.util;

import com.example.demo.request.UserRequestBO;
import com.example.demo.request.UserRequestDTO;
import com.example.demo.response.UserResponseBO;
import com.example.demo.response.UserResponseDTO;

/**
 * @ClassName BaseConverter
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 14:21
 * @Version 1.0
 **/
public class BaseConverter {
    /**
     * dto 转 bo
     * @param userrequestDTO
     * @return
     */
    public  UserRequestBO userRequestDtoToBO(UserRequestDTO userrequestDTO){

        UserRequestBO userRequestBO = new UserRequestBO();
        userRequestBO.setProdId(userrequestDTO.getProdId());
        userRequestBO.setStr1(userrequestDTO.getStr1());
        userRequestBO.setSysId(userrequestDTO.getSysId());
        userRequestBO.setTermOrdId(userrequestDTO.getTermOrdId());
        userRequestBO.setTrancId(userrequestDTO.getTrancId());

        return userRequestBO;

    }

    /**
     * bo 转 dto
     * @param userRequestBO
     * @return
     */
    public  UserRequestDTO userRequestBoToDTO(UserRequestBO userRequestBO) {

        UserRequestDTO userRequestDTO = new UserRequestDTO();

        userRequestDTO.setProdId(userRequestBO.getProdId());
        userRequestDTO.setStr1(userRequestBO.getStr1());
        userRequestDTO.setSysId(userRequestBO.getSysId());
        userRequestDTO.setTermOrdId(userRequestBO.getTermOrdId());
        userRequestDTO.setTrancId(userRequestBO.getTrancId());

        return userRequestDTO;

    }


    /**
     * 返回对象转DTO
     * @param userResponseBO
     * @return
     */
    public  UserResponseDTO userResponseBoToDTO(UserResponseBO userResponseBO){

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setRestCode(userResponseBO.getRestCode());
        userResponseDTO.setRestDesc(userResponseBO.getRestDesc());
        userResponseDTO.setSysId(userResponseBO.getSysId());
        userResponseDTO.setTrancId(userResponseBO.getTrancId());

        return userResponseDTO;

    }

    /**
     * 返回对象转bo
     * @param userResponseDTO
     * @return
     */
    public  UserResponseBO userResponseDtoToBO(UserResponseDTO userResponseDTO){

        UserResponseBO userResponseBO = new UserResponseBO();

        userResponseBO.setRestCode(userResponseDTO.getRestCode());
        userResponseBO.setRestDesc(userResponseDTO.getRestDesc());
        userResponseBO.setSysId(userResponseDTO.getSysId());
        userResponseBO.setTrancId(userResponseDTO.getTrancId());

        return userResponseBO;


    }
}
