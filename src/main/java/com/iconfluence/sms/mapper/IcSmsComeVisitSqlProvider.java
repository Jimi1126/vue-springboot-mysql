package com.iconfluence.sms.mapper;

import com.iconfluence.sms.model.IcSmsComeVisit;
import com.iconfluence.sms.model.IcSmsComeVisitExample;
import com.iconfluence.sms.model.IcSmsComeVisitExample.Criteria;
import com.iconfluence.sms.model.IcSmsComeVisitExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class IcSmsComeVisitSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String countByExample(IcSmsComeVisitExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ic_sms_come_visit");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String deleteByExample(IcSmsComeVisitExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ic_sms_come_visit");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String insertSelective(IcSmsComeVisit record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ic_sms_come_visit");
        
        if (record.getGid() != null) {
            sql.VALUES("gid", "#{gid,jdbcType=VARCHAR}");
        }
        
        if (record.getYear() != null) {
            sql.VALUES("year", "#{year,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitTime() != null) {
            sql.VALUES("visit_time", "#{visitTime,jdbcType=VARCHAR}");
        }
        
        if (record.getObjective() != null) {
            sql.VALUES("objective", "#{objective,jdbcType=VARCHAR}");
        }
        
        if (record.getCUser() != null) {
            sql.VALUES("c_user", "#{cUser,jdbcType=VARCHAR}");
        }
        
        if (record.getHlUser() != null) {
            sql.VALUES("hl_user", "#{hlUser,jdbcType=VARCHAR}");
        }
        
        if (record.getResult() != null) {
            sql.VALUES("result", "#{result,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitUnit() != null) {
            sql.VALUES("visit_unit", "#{visitUnit,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String selectByExample(IcSmsComeVisitExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("gid");
        } else {
            sql.SELECT("gid");
        }
        sql.SELECT("year");
        sql.SELECT("visit_time");
        sql.SELECT("objective");
        sql.SELECT("c_user");
        sql.SELECT("hl_user");
        sql.SELECT("result");
        sql.SELECT("remark");
        sql.SELECT("uid");
        sql.SELECT("visit_unit");
        sql.FROM("ic_sms_come_visit");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        IcSmsComeVisit record = (IcSmsComeVisit) parameter.get("record");
        IcSmsComeVisitExample example = (IcSmsComeVisitExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_come_visit");
        
        if (record.getGid() != null) {
            sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        }
        
        if (record.getYear() != null) {
            sql.SET("year = #{record.year,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitTime() != null) {
            sql.SET("visit_time = #{record.visitTime,jdbcType=VARCHAR}");
        }
        
        if (record.getObjective() != null) {
            sql.SET("objective = #{record.objective,jdbcType=VARCHAR}");
        }
        
        if (record.getCUser() != null) {
            sql.SET("c_user = #{record.cUser,jdbcType=VARCHAR}");
        }
        
        if (record.getHlUser() != null) {
            sql.SET("hl_user = #{record.hlUser,jdbcType=VARCHAR}");
        }
        
        if (record.getResult() != null) {
            sql.SET("result = #{record.result,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitUnit() != null) {
            sql.SET("visit_unit = #{record.visitUnit,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_come_visit");
        
        sql.SET("gid = #{record.gid,jdbcType=VARCHAR}");
        sql.SET("year = #{record.year,jdbcType=VARCHAR}");
        sql.SET("visit_time = #{record.visitTime,jdbcType=VARCHAR}");
        sql.SET("objective = #{record.objective,jdbcType=VARCHAR}");
        sql.SET("c_user = #{record.cUser,jdbcType=VARCHAR}");
        sql.SET("hl_user = #{record.hlUser,jdbcType=VARCHAR}");
        sql.SET("result = #{record.result,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=VARCHAR}");
        sql.SET("visit_unit = #{record.visitUnit,jdbcType=VARCHAR}");
        
        IcSmsComeVisitExample example = (IcSmsComeVisitExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(IcSmsComeVisit record) {
        SQL sql = new SQL();
        sql.UPDATE("ic_sms_come_visit");
        
        if (record.getYear() != null) {
            sql.SET("year = #{year,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitTime() != null) {
            sql.SET("visit_time = #{visitTime,jdbcType=VARCHAR}");
        }
        
        if (record.getObjective() != null) {
            sql.SET("objective = #{objective,jdbcType=VARCHAR}");
        }
        
        if (record.getCUser() != null) {
            sql.SET("c_user = #{cUser,jdbcType=VARCHAR}");
        }
        
        if (record.getHlUser() != null) {
            sql.SET("hl_user = #{hlUser,jdbcType=VARCHAR}");
        }
        
        if (record.getResult() != null) {
            sql.SET("result = #{result,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitUnit() != null) {
            sql.SET("visit_unit = #{visitUnit,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("gid = #{gid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ic_sms_come_visit
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, IcSmsComeVisitExample example, boolean includeExamplePhrase) {
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