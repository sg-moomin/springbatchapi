package com.sgmoomin.springbatch.springbatchapi.job.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sgmoomin.springbatch.springbatchapi.job.tasklet.MemberSelectTasklet;
import com.sgmoomin.springbatch.springbatchapi.job.tasklet.MemberTasklet;


@Configuration
public class MemberStep {
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MemberTasklet memberTasklet;
    
    @Autowired
    private MemberSelectTasklet memberSelectTasklet;

    @Bean(name = "getMemberStep1")
    public Step getMemberStep1(){
        return stepBuilderFactory.get("getMemberStep1")
            .tasklet(memberTasklet)
            .build();
    }

    @Bean(name = "getMemberStep2")
    public Step getMemberStep2(){
        return stepBuilderFactory.get("getMemberStep2")
            .tasklet(memberTasklet)

            .build();
    }


    @Bean(name = "getMemberStep3")
    public Step getMemberStep3(){
        return stepBuilderFactory.get("getMemberStep3")
            .tasklet(memberTasklet)
            .build();
    }

    @Bean(name = "selectMemberStep")
    public Step selectMemberStep(){
        return stepBuilderFactory.get("selectMemberStep")
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
