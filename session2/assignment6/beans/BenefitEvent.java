package com.scg.beans;

import java.time.LocalDate;
import java.util.EventObject;
import java.util.Optional;

import com.scg.domain.Consultant;
import com.scg.util.PersonalName;

/**
 * Event used to notify listeners of a Consultant's enrollment or cancellation of 
 * medical or dental benefits.
 * @author Brian Stamm
 */
public final class BenefitEvent extends EventObject{

	private static final long serialVersionUID = 3546889664775360423L;
	transient private Optional <Boolean> enrolledInMedical;
	transient private Optional <Boolean> enrolledInDental;
	private final Consultant consultant;
	private final LocalDate effectiveDate;

	public BenefitEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub

	}
	
	/**
	 * Creates a medical enrollment event.
	 * @param source - the event source
	 * @param consultant - the consultant being terminated
	 * @param effectiveDate - effective date of enrollment
	 * @return a new event object
	 */
	public static BenefitEvent enrollMedical(Object source,Consultant consultant,java.time.LocalDate effectiveDate) {
		return new BenefitEvent(source,consultant, effectiveDate,Optional.of(true),Optional.empty());
	}
	
	/**
	 * Creates a medical cancellation event.
	 * @param source - the event source
	 * @param consultant - the consultant being terminated
	 * @param effectiveDate - effective date of enrollment
	 * @return
	 */
	public static BenefitEvent cancelMedical(Object source,
            Consultant consultant,
            java.time.LocalDate effectiveDate) {
		return new BenefitEvent(source,consultant, effectiveDate,Optional.of(false),Optional.empty());
	}
	
	/**
	 * Creates a dental enrollment event.
	 * @param source - the event source
	 * @param consultant - the consultant being terminated
	 * @param effectiveDate - effective date of enrollment
	 * @return
	 */
	public static BenefitEvent enrollDental(Object source,
            Consultant consultant,
            java.time.LocalDate effectiveDate) {
		return new BenefitEvent(source,consultant, effectiveDate,Optional.empty(),Optional.of(true));
	}
	
	/**
	 * Creates a dental cancellation event.
	 * @param source
	 * @param consultant
	 * @param effectiveDate
	 * @return
	 */
	public static BenefitEvent cancelDental(Object source,
            Consultant consultant,
            java.time.LocalDate effectiveDate) {
		return new BenefitEvent(source,consultant, effectiveDate,Optional.empty(),Optional.of(false));
	}
	
	private BenefitEvent (Object source,
            Consultant consultant,
            java.time.LocalDate effectiveDate,Optional<Boolean> enrolledInMedical) {
		super(source);
		this.consultant = consultant;
		this.effectiveDate = effectiveDate;
		this.enrolledInMedical = enrolledInMedical;
	}
	
	/**
	 * Gets the medical enrollment status.
	 * @return true if enrolled event, false if cancellation, empty if not a medical enrollment event.
	 */
	public Optional<Boolean> medicalStatus(){
		return enrolledInMedical;
	}
	
	/**
	 * Gets the dental enrollment status.
	 * @return true enrolled event, false if cancellation, empty if not a dental enrollment event.
	 */
	public Optional<Boolean> dentalStatus(){
		return;
	}
	
	/**
	 * Gets the consultant that was terminated.
	 * @return the consultant that was terminated
	 */
	public Consultant getConsultant() {
		return new Consultant(new PersonalName("Stamm", "Brian"));
	}
	
	/**
	 * Gets the effective date.
	 * @return the effective date
	 */
	public LocalDate getEffectiveDate(){
		return LocalDate.now();
	}

}
