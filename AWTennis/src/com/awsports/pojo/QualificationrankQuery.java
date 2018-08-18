package com.awsports.pojo;

public class QualificationrankQuery {
	private Qualificationrank qualificationrank;
	private UserQuery userQuery;
	private Tournament tournament;
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public Qualificationrank getQualificationrank() {
		return qualificationrank;
	}
	public void setQualificationrank(Qualificationrank qualificationrank) {
		this.qualificationrank = qualificationrank;
	}
	public UserQuery getUserQuery() {
		return userQuery;
	}
	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}
}
