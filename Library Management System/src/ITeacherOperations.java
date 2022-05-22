
public interface ITeacherOperations {
	void insertTeacher(Teacher t);
	void removeTeacher(Teacher t);
	Teacher getTeacher(String teacherId);
	void showAllTeachers( );
}
