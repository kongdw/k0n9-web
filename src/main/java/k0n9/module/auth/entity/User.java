package k0n9.module.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import k0n9.common.entity.BaseEntity;
import k0n9.common.utils.DateUtils;
import k0n9.common.web.json.DateJsonSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * @author David Kong
 * @version 1.0
 */
public class User extends BaseEntity<Long> {

    private static final long serialVersionUID = -5022978212427928617L;
    /**
     * 用户ID
     */
    private Long id;

    private String username;

    private String email;

    private String phoneNumber;

    private String password;
    /**
     * 加密盐值
     */
    private String salt;

    private Date createDate;
    /**
     * 状态 删除、停用、正常、过期等
     */
    private String status;
    /**
     * 删除标识
     */
    private Boolean deleted = Boolean.FALSE;
    /**
     * 是否管理员
     */
    private Boolean isAdmin = Boolean.FALSE;
    /**
     * 关联角色列表
     */
    private List<Role> roleList;
    /**
     * 用户组织机构
     */
    private List<Organization> organizationList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @DateTimeFormat(pattern = DateUtils.DEFAULT_DATE_FORMAT)
    @JsonSerialize(using = DateJsonSerializer.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Role> getRoleList() {
        if (roleList == null) {
            roleList = Lists.newArrayList();
        }
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Organization> getOrganizationList() {
        if (organizationList == null) {
            organizationList = Lists.newArrayList();
        }
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }
}
