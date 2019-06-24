package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsCustomerContact;
import com.iconfluence.sms.model.IcSmsCustomerContactExample;
import com.iconfluence.sms.model.IcSmsCustomerContactExample.Criteria;
import com.iconfluence.sms.model.IcSmsCustomerContactExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class IcSmsCustomerContactSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String countByExample(IcSmsCustomerContactExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ic_sms_customer_contact");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String deleteByExample(IcSmsCustomerContactExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ic_sms_customer_contact");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String insertSelective(IcSmsCustomerContact record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ic_sms_customer_contact");
        
        if (record.getGid() != null) {
            sql.VALUES("gid", "#{gid,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            sql.VALUES("cid", "#{cid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            sql.VALUES("department", "#{department,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            sql.VALUES("qq", "#{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getMsn() != null) {
            sql.VALUES("msn", "#{msn,jdbcType=VARCHAR}");
        }
        
        if (record.getIcq() != null) {
            sql.VALUES("icq", "#{icq,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getIsImportant() != null) {
            sql.VALUES("is_important", "#{isImportant,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.VALUES("fax", "#{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaCode() != null) {
            sql.VALUES("area_code", "#{areaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtension() != null) {
            sql.VALUES("extension", "#{extension,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=BINARY}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String selectByExampleWithBLOBs(IcSmsCustomerContactExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("gid");
        } else {
            sql.SELECT("gid");
        }
        sql.SELECT("cid");
        sql.SELECT("name");
        sql.SELECT("department");
        sql.SELECT("phone");
        sql.SELECT("mobile");
        sql.SELECT("qq");
        sql.SELECT("msn");
        sql.SELECT("icq");
        sql.SELECT("email");
        sql.SELECT("is_important");
        sql.SELECT("remark");
        sql.SELECT("create_time");
        sql.SELECT("fax");
        sql.SELECT("area_code");
        sql.SELECT("extension");
        sql.SELECT("sex");
        sql.FROM("ic_sms_customer_contact");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String selectByExample(IcSmsCustomerContactExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("gid");
        } else {
            sql.SELECT("gid");
        }
        sql.SELECT("cid");
        sql.SELECT("name");
        sql.SELECT("department");
        sql.SELECT("phone");
        sql.SELECT("mobile");
        sql.SELECT("qq");
        sql.SELECT("msn");
        sql.SELECT("icq");
        sql.SELECT("email");
        sql.SELECT("is_important");
        sql.SELECT("remark");
        sql.SELECT("create_time");
        sql.SELECT("fax");
        sql.SELECT("area_code");
        sql.SELECT("extension");
        sql.FROM("ic_sms_customer_contact");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        IcSmsCustomerContact record = (IcSmsCustomerContact) parameter.get("record");
        IcSmsCustomerContactExample example = (IcSmsCustomerContactExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_contact");
        
        if (record.getGid() != null) {
            sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            sql.SET("cid = #{record.cid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            sql.SET("department = #{record.department,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            sql.SET("qq = #{record.qq,jdbcType=VARCHAR}");
        }
        
        if (record.getMsn() != null) {
            sql.SET("msn = #{record.msn,jdbcType=VARCHAR}");
        }
        
        if (record.getIcq() != null) {
            sql.SET("icq = #{record.icq,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getIsImportant() != null) {
            sql.SET("is_important = #{record.isImportant,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.SET("fax = #{record.fax,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaCode() != null) {
            sql.SET("area_code = #{record.areaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtension() != null) {
            sql.SET("extension = #{record.extension,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{record.sex,jdbcType=BINARY}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_contact");
        
        sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        sql.SET("cid = #{record.cid,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("department = #{record.department,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("qq = #{record.qq,jdbcType=VARCHAR}");
        sql.SET("msn = #{record.msn,jdbcType=VARCHAR}");
        sql.SET("icq = #{record.icq,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("is_important = #{record.isImportant,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        sql.SET("fax = #{record.fax,jdbcType=VARCHAR}");
        sql.SET("area_code = #{record.areaCode,jdbcType=VARCHAR}");
        sql.SET("extension = #{record.extension,jdbcType=VARCHAR}");
        sql.SET("sex = #{record.sex,jdbcType=BINARY}");
        
        IcSmsCustomerContactExample example = (IcSmsCustomerContactExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_contact");
        
        sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        sql.SET("cid = #{record.cid,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("department = #{record.department,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("qq = #{record.qq,jdbcType=VARCHAR}");
        sql.SET("msn = #{record.msn,jdbcType=VARCHAR}");
        sql.SET("icq = #{record.icq,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("is_important = #{record.isImportant,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        sql.SET("fax = #{record.fax,jdbcType=VARCHAR}");
        sql.SET("area_code = #{record.areaCode,jdbcType=VARCHAR}");
        sql.SET("extension = #{record.extension,jdbcType=VARCHAR}");
        
        IcSmsCustomerContactExample example = (IcSmsCustomerContactExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(IcSmsCustomerContact record) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_contact");
        
        if (record.getCid() != null) {
            sql.SET("cid = #{cid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            sql.SET("department = #{department,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            sql.SET("qq = #{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getMsn() != null) {
            sql.SET("msn = #{msn,jdbcType=VARCHAR}");
        }
        
        if (record.getIcq() != null) {
            sql.SET("icq = #{icq,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getIsImportant() != null) {
            sql.SET("is_important = #{isImportant,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.SET("fax = #{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaCode() != null) {
            sql.SET("area_code = #{areaCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtension() != null) {
            sql.SET("extension = #{extension,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=BINARY}");
        }
        
        sql.WHERE("gid = #{gid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_contact
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, IcSmsCustomerContactExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}