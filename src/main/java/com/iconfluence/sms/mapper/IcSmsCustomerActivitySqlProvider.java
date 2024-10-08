package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsCustomerActivity;
import com.iconfluence.sms.model.IcSmsCustomerActivityExample.Criteria;
import com.iconfluence.sms.model.IcSmsCustomerActivityExample.Criterion;
import com.iconfluence.sms.model.IcSmsCustomerActivityExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class IcSmsCustomerActivitySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String countByExample(IcSmsCustomerActivityExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ic_sms_customer_activity");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String deleteByExample(IcSmsCustomerActivityExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ic_sms_customer_activity");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String insertSelective(IcSmsCustomerActivity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ic_sms_customer_activity");
        
        if (record.getGid() != null) {
            sql.VALUES("GID", "#{gid,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            sql.VALUES("CID", "#{cid,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.VALUES("SUBJECT", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            sql.VALUES("CONTACT", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getTouchTime() != null) {
            sql.VALUES("TOUCH_TIME", "#{touchTime,jdbcType=VARCHAR}");
        }
        
        if (record.getRecord() != null) {
            sql.VALUES("RECORD", "#{record,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("TYPE", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getNextTime() != null) {
            sql.VALUES("NEXT_TIME", "#{nextTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPotential() != null) {
            sql.VALUES("POTENTIAL", "#{potential,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String selectByExample(IcSmsCustomerActivityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("GID");
        } else {
            sql.SELECT("GID");
        }
        sql.SELECT("CID");
        sql.SELECT("SUBJECT");
        sql.SELECT("CONTACT");
        sql.SELECT("TOUCH_TIME");
        sql.SELECT("RECORD");
        sql.SELECT("TYPE");
        sql.SELECT("NEXT_TIME");
        sql.SELECT("POTENTIAL");
        sql.SELECT("REMARK");
        sql.SELECT("CREATE_TIME");
        sql.SELECT("grade");
        sql.FROM("ic_sms_customer_activity");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        IcSmsCustomerActivity record = (IcSmsCustomerActivity) parameter.get("record");
        IcSmsCustomerActivityExample example = (IcSmsCustomerActivityExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_activity");
        
        if (record.getGid() != null) {
            sql.SET("GID = #{record.gid,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            sql.SET("CID = #{record.cid,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("SUBJECT = #{record.subject,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            sql.SET("CONTACT = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getTouchTime() != null) {
            sql.SET("TOUCH_TIME = #{record.touchTime,jdbcType=VARCHAR}");
        }
        
        if (record.getRecord() != null) {
            sql.SET("RECORD = #{record.record,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("TYPE = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getNextTime() != null) {
            sql.SET("NEXT_TIME = #{record.nextTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPotential() != null) {
            sql.SET("POTENTIAL = #{record.potential,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{record.createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{record.grade,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_activity");
        
        sql.SET("GID = #{record.gid,jdbcType=VARCHAR}");
        sql.SET("CID = #{record.cid,jdbcType=VARCHAR}");
        sql.SET("SUBJECT = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("CONTACT = #{record.contact,jdbcType=VARCHAR}");
        sql.SET("TOUCH_TIME = #{record.touchTime,jdbcType=VARCHAR}");
        sql.SET("RECORD = #{record.record,jdbcType=VARCHAR}");
        sql.SET("TYPE = #{record.type,jdbcType=VARCHAR}");
        sql.SET("NEXT_TIME = #{record.nextTime,jdbcType=VARCHAR}");
        sql.SET("POTENTIAL = #{record.potential,jdbcType=VARCHAR}");
        sql.SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CREATE_TIME = #{record.createTime,jdbcType=VARCHAR}");
        sql.SET("grade = #{record.grade,jdbcType=VARCHAR}");
        
        IcSmsCustomerActivityExample example = (IcSmsCustomerActivityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(IcSmsCustomerActivity record) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_customer_activity");
        
        if (record.getCid() != null) {
            sql.SET("CID = #{cid,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("SUBJECT = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            sql.SET("CONTACT = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getTouchTime() != null) {
            sql.SET("TOUCH_TIME = #{touchTime,jdbcType=VARCHAR}");
        }
        
        if (record.getRecord() != null) {
            sql.SET("RECORD = #{record,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("TYPE = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getNextTime() != null) {
            sql.SET("NEXT_TIME = #{nextTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPotential() != null) {
            sql.SET("POTENTIAL = #{potential,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("GID = #{gid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_customer_activity
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, IcSmsCustomerActivityExample example, boolean includeExamplePhrase) {
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