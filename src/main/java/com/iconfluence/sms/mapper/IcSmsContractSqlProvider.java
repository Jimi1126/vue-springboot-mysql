package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsContract;
import com.iconfluence.sms.model.IcSmsContractExample;
import com.iconfluence.sms.model.IcSmsContractExample.Criteria;
import com.iconfluence.sms.model.IcSmsContractExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class IcSmsContractSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String countByExample(IcSmsContractExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ic_sms_contract");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String deleteByExample(IcSmsContractExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ic_sms_contract");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String insertSelective(IcSmsContract record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ic_sms_contract");
        
        if (record.getGid() != null) {
            sql.VALUES("gid", "#{gid,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTrade() != null) {
            sql.VALUES("trade", "#{trade,jdbcType=VARCHAR}");
        }
        
        if (record.getTerm() != null) {
            sql.VALUES("term", "#{term,jdbcType=VARCHAR}");
        }
        
        if (record.getContractTime() != null) {
            sql.VALUES("contract_time", "#{contractTime,jdbcType=VARCHAR}");
        }
        
        if (record.getOverTime() != null) {
            sql.VALUES("over_time", "#{overTime,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCooperationType() != null) {
            sql.VALUES("cooperation_type", "#{cooperationType,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnTime() != null) {
            sql.VALUES("return_time", "#{returnTime,jdbcType=VARCHAR}");
        }
        
        if (record.getQuality() != null) {
            sql.VALUES("quality", "#{quality,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String selectByExample(IcSmsContractExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("gid");
        } else {
            sql.SELECT("gid");
        }
        sql.SELECT("customer_name");
        sql.SELECT("name");
        sql.SELECT("type");
        sql.SELECT("trade");
        sql.SELECT("term");
        sql.SELECT("contract_time");
        sql.SELECT("over_time");
        sql.SELECT("status");
        sql.SELECT("cooperation_type");
        sql.SELECT("return_time");
        sql.SELECT("quality");
        sql.SELECT("remark");
        sql.SELECT("uid");
        sql.FROM("ic_sms_contract");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        IcSmsContract record = (IcSmsContract) parameter.get("record");
        IcSmsContractExample example = (IcSmsContractExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_contract");
        
        if (record.getGid() != null) {
            sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getTrade() != null) {
            sql.SET("trade = #{record.trade,jdbcType=VARCHAR}");
        }
        
        if (record.getTerm() != null) {
            sql.SET("term = #{record.term,jdbcType=VARCHAR}");
        }
        
        if (record.getContractTime() != null) {
            sql.SET("contract_time = #{record.contractTime,jdbcType=VARCHAR}");
        }
        
        if (record.getOverTime() != null) {
            sql.SET("over_time = #{record.overTime,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getCooperationType() != null) {
            sql.SET("cooperation_type = #{record.cooperationType,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnTime() != null) {
            sql.SET("return_time = #{record.returnTime,jdbcType=VARCHAR}");
        }
        
        if (record.getQuality() != null) {
            sql.SET("quality = #{record.quality,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_contract");
        
        sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        sql.SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("trade = #{record.trade,jdbcType=VARCHAR}");
        sql.SET("term = #{record.term,jdbcType=VARCHAR}");
        sql.SET("contract_time = #{record.contractTime,jdbcType=VARCHAR}");
        sql.SET("over_time = #{record.overTime,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        sql.SET("cooperation_type = #{record.cooperationType,jdbcType=VARCHAR}");
        sql.SET("return_time = #{record.returnTime,jdbcType=VARCHAR}");
        sql.SET("quality = #{record.quality,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=VARCHAR}");
        
        IcSmsContractExample example = (IcSmsContractExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(IcSmsContract record) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_contract");
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTrade() != null) {
            sql.SET("trade = #{trade,jdbcType=VARCHAR}");
        }
        
        if (record.getTerm() != null) {
            sql.SET("term = #{term,jdbcType=VARCHAR}");
        }
        
        if (record.getContractTime() != null) {
            sql.SET("contract_time = #{contractTime,jdbcType=VARCHAR}");
        }
        
        if (record.getOverTime() != null) {
            sql.SET("over_time = #{overTime,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCooperationType() != null) {
            sql.SET("cooperation_type = #{cooperationType,jdbcType=VARCHAR}");
        }
        
        if (record.getReturnTime() != null) {
            sql.SET("return_time = #{returnTime,jdbcType=VARCHAR}");
        }
        
        if (record.getQuality() != null) {
            sql.SET("quality = #{quality,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("gid = #{gid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_contract
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, IcSmsContractExample example, boolean includeExamplePhrase) {
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