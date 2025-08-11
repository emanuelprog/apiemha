package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOnlineDTO {
    private Long id;
    private Long legacySystemCode;
    private Long registrationPassword;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private ChartDTO maritalStatus;
    private String motherName;
    private String fatherName;
    private Character nationality;
    private String naturalPlace;
    private ProfessionDTO profession;
    private ChartDTO professionalStatus;
    private Float income;
    private String cpf;
    private Boolean isWheelchair;
    private Boolean hasChronicDisease;
    private Boolean isElderly;
    private Boolean hasPhysicalDisability;
    private DeficiencyDTO deficiency;
    private String rg;
    private String rgIssuer;
    private ChartDTO rgState;
    private LocalDate rgIssueDate;
    private String nis;
    private String spouseName;
    private String spouseGender;
    private LocalDate spouseBirthDate;
    private String spouseMotherName;
    private String spouseFatherName;
    private String spouseCpf;
    private String spouseRgNumber;
    private String phone;
    private String mobile;
    private String email;
    private ChartDTO housingType;
    private ChartDTO areaType;
    private ChartDTO housingSituation;
    private Float rentValue;
    private String householdResponsibleGender;
    private Long residenceTime;
    private String residenceTimeType;
    private String workNeighborhood;
    private String workRegion;
    private Boolean wantsApartment;
    private Boolean wantsHouse;
    private Boolean wantsTownhouse;
    private Boolean wantsLand;
    private Boolean wantsLandAndMaterial;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String spouseNis;
    private String benefitContractNumber;
    private String benefitedConjunto;
    private String benefitBlockNumber;
    private String benefitBlockCode;
    private String benefitLotNumber;
    private String benefitLotCode;
    private String benefitModule;
    private Boolean isSpouseDependent;
    private String spouseNationality;
    private String contactPhone;
    private Long projectId;
    private Long programId;
    private Boolean updatedViaKattle;
    private String socialName;
    private Boolean hasChildrenUnder14;
    private Boolean hasEldersAsDependents;
    private String isBloodDonor;
    private ProfessionDTO spouseProfession;
    private ChartDTO spouseProfessionStatus;
    private Boolean isViolenceVictim;
    private String contactName;
    private String socialNetwork;
    private String comonl;
    private Boolean caponl;
    private Boolean liveOrWork3KmFromTheDevelopment;
    private Boolean ownsProperty;
    private Boolean hasDisablingChronicDisease;
    private Boolean cras;
    private Boolean creas;
    private String creditRestrictionFlag;
    private Boolean wantsSubsidizedLoan;
    private Boolean wantsSocialRentFlag;
    private String formattedIncome;
    private String formattedRentValue;
    private String ethnicity;
    private String indigenousEthnicity;
    private String spouseEthnicity;
    private String spouseIndigenousEthnicity;
    private Boolean livesInVillage;
    private Boolean isQuilombola;
    private Boolean hasDisability;
    private Boolean spouseHasDisability;
    private Boolean spouseHasWorkLimitingDisease;
    private Boolean spouseHasDegenerativeDisease;
    private Boolean hasCancer;
    private Boolean spouseHasCancer;
    private Boolean spouseIsElderly;
    private Boolean hasPrecariousHousing;
    private Boolean isInCoHousing;
    private Boolean hasOvercrowding;
    private Boolean livesInRiskArea;
    private Boolean hasExcessiveRentBurden;
    private Boolean receivesRentSubsidy;
    private Boolean isHomeless;
    private Boolean hasDegenerativeDisease;
    private Boolean spouseLivesInVillage;
    private Boolean spouseIsQuilombola;
    private Boolean spouseHasChronicDisease;
    private Boolean sitpreonl;
    private Boolean isSingleParentFamily;
    private List<AddressDTO> addresses;
    private List<DependentDTO> dependents;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Summary {
        private Long id;
        private String name;
        private String formattedCpf;
        private String isElderly;
        private String hasDisability;
        private Long referenceYear;
        private String status;
    }
}