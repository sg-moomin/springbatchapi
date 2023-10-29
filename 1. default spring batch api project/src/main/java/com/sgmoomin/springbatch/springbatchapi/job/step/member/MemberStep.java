package com.sgmoomin.springbatch.springbatchapi.job.step.member;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sgmoomin.springbatch.springbatchapi.common.code.BatchStepNameType;
import com.sgmoomin.springbatch.springbatchapi.job.tasklet.member.MemberSelectTasklet;
import com.sgmoomin.springbatch.springbatchapi.job.tasklet.member.MemberTasklet;


@Configuration
public class MemberStep {
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MemberTasklet memberTasklet;
    
    @Autowired
    private MemberSelectTasklet memberSelectTasklet;

    @Bean(name = BatchStepNameType.STEP_ANNOTATAION.GET_MEMBER_STEP)
    public Step getMemberStep(){
        return stepBuilderFactory.get(BatchStepNameType.GET_MEMBER_STEP_NAME.getValue())
            .tasklet(memberTasklet)
            .build();
    }

    @Bean(name = BatchStepNameType.STEP_ANNOTATAION.SELECT_MEMBER_STEP)
    public Step selectMemberStep(){
        return stepBuilderFactory.get(BatchStepNameType.SELECT_MEMBER_STEP_NAME.getValue())
            .tasklet(memberSelectTasklet)
            .build();
    }

    // @Bean
    //     public Step step1(){
    //     return stepBuilderFactory.get("step1")
    //             .tasklet((stepContribution, chunkContext) -> {

    //                 log.debug("======= 전송 배치 시작 =======");
    //                 LockTable lockTable = Optional
    //                         .ofNullable(lockTableRepository.findOne("play-batch"))
    //                         .orElse(LockTable
    //                                 .builder()
    //                                 .instanceId(instanceId)
    //                                 .useYn(false)
    //                                 .checkDataTime(LocalDateTime.now())
    //                                 .build());
    //                 log.debug("======= Lock Table 사용 여부:{},", lockTable.isUseYn());
    //                 if(lockTable.isUseYn()){
    //                     log.debug("======= Table 사용 중으로 종료 ");
    //                     stepContribution.setExitStatus(ExitStatus.FAILED);
    //                 }else{
    //                     lockTable.setUseYn(true);
    //                     lockTableRepository.save(lockTable);
    //                 }
    //                 return RepeatStatus.FINISHED;
    //             }).build();
}
