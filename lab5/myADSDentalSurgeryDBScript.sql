



//Display the list of ALL Dentists registered in the system, sorted in ascending order of their last names
SELECT * FROM Dentist
ORDER BY LastName ASC;



//Display the list of ALL Appointments for a given Dentist by their DentistID number. Include in the result, the Patient information

SELECT A.*, D.FirstName AS DentistFirstName, D.LastName AS DentistLastName, P.FirstName AS PatientFirstName, P.LastName AS PatientLastName
FROM Appointment A
JOIN Dentist D ON A.DentistID = D.DentistID
JOIN Patient P ON A.PatientID = P.PatientID
WHERE A.DentistID = 2;



//Display the list of ALL Appointments that have been scheduled at a Surgery Location

SELECT A.*, D.FirstName AS DentistFirstName, D.LastName AS DentistLastName, P.FirstName AS PatientFirstName, P.LastName AS PatientLastName, S.Name AS SurgeryName, S.LocationAddress AS SurgeryLocation
FROM Appointment A
JOIN Dentist D ON A.DentistID = D.DentistID
JOIN Patient P ON A.PatientID = P.PatientID
JOIN Surgery S ON D.SurgeryID = (SELECT SurgeryID FROM Dentist WHERE Dentist.DentistID = A.DentistID);


//Display the list of the Appointments booked for a given Patient on a given Date

SELECT A.*, D.FirstName AS DentistFirstName, D.LastName AS DentistLastName
FROM Appointment A
JOIN Dentist D ON A.DentistID = D.DentistID
WHERE A.PatientID = 1 AND A.Date = '2023-10-20';