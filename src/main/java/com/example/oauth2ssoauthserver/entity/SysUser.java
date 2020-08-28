package com.example.oauth2ssoauthserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class SysUser {
    @TableId("user_id")
    private String userId;
    @TableField("user_name")
    private String userName;
    @TableField("user_passwd")
    private String userPasswd;
}
