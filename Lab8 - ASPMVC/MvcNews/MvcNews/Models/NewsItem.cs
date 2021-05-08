using System;
using System.ComponentModel.DataAnnotations;

namespace MvcNews.Models
{
    public class NewsItem
    {
        public int Id { get; set; }
        [DataType(DataType.Date)]
        public DateTime TimeStamp { get; set; }
        [Required]
        [StringLength(140, MinimumLength = 5)]
        public string Text { get; set; }
        // Warte uwagi!
        // Tworzy znacznik czasowy. Jeśli próbuję zmodyfikować rekord, który zmodyfikowałem wcześniej,
        // a o tymn nie wiem, to znaczniki się nie zgadzają i rzucany jest Exception.
        [Timestamp]
        public byte[] RowVersion { get; set; }
    }
}
