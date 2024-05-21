package com.mycompany.group234.converter;

import com.mycompany.group234.enums.OnBoardingStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class OnBoardingStatusConverter implements AttributeConverter<OnBoardingStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OnBoardingStatus onBoardingStatus) {
        return onBoardingStatus != null ? onBoardingStatus.ordinal() : null;
    }

    @Override
    public OnBoardingStatus convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return OnBoardingStatus.getOnBoardingStatus(dbData);
    }
}
