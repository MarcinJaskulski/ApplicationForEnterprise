using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

#nullable disable

namespace CompanyApi.Models.Database
{
    [Table("Employee")]
    public partial class Employee
    {
        public Employee()
        {
            Subordinate = new HashSet<Employee>();
        }

        [Key]
        public int EmployeeId { get; set; }
        [StringLength(15)]
        public string FirstName { get; set; }
        [StringLength(15)]
        public string LastName { get; set; }
        public int? ManagerId { get; set; }
        [Column(TypeName = "decimal(6, 2)")]
        public decimal? Salary { get; set; }
        [Column(TypeName = "decimal(6, 2)")]
        public decimal? Bonus { get; set; }
        public int? DepartmentId { get; set; }

        [ForeignKey(nameof(DepartmentId))]
        [InverseProperty("Employees")]
        public virtual Department Department { get; set; }
        [ForeignKey(nameof(ManagerId))]
        [InverseProperty(nameof(Employee.Subordinate))]
        public virtual Employee Manager { get; set; }
        [InverseProperty(nameof(Employee.Manager))]
        public virtual ICollection<Employee> Subordinate { get; set; }
    }
}
