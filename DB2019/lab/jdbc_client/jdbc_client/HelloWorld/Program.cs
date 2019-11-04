using System;
using Npgsql;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            //TODO dotnet add package Npgsql --version 3.2.7 

            //TODO http://www.npgsql.org/doc/prepare.html

            var connString = "Server=localhost;Port=5433;User Id=postgres;Password=123456;Database=galene";
            var conn = new NpgsqlConnection {ConnectionString = connString};
            conn.Open();
            var sql = "select 6";
            var cmd = conn.CreateCommand();
            cmd.CommandText = sql;
            var count = cmd.ExecuteScalar();
            Console.WriteLine("Count: " + count);
            conn.Close();

        }
    }
}
