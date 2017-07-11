package crudoperation.dao;

import crudoperation.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axmedbek on 7/10/17.
 */
public class UserDaoImpl implements UserDao{

    private Connection con = null;


    public void save(User user) {


        String sql = "insert into music(fname,lname,email) values(?,?,?)";

        try
        {

            Connection con = DBUtil.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1,user.getFirstName());
            pr.setString(2,user.getLastName());
            pr.setString(3,user.getEmail());
            pr.executeUpdate();
            pr.close();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally
        {
            if(con!=null)
            {
                try
                {

                    con.close();
                }
                catch (Exception e){}
            }
        }
    }

    public User findUserById(int id) {
        String sql = "select * from music where id=?";
        User user = new User();


        try
        {
            Connection con = DBUtil.getConnection();
            PreparedStatement pr=con.prepareStatement(sql);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if(rs.next())
            {
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));

            }
            else
                {
                    user=null;
                }


        }
        catch (SQLException e)
        {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(con!=null)
            {
                try
                {
                    con.close();
                }
                catch (Exception e)
                {

                }
            }
        }
        return user;
    }

    public List<User> allUser() {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from music";
        try
        {
            Connection con=DBUtil.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs= pr.executeQuery();
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setEmail(rs.getString(4));
                userList.add(user);
            }
            pr.close();
            rs.close();
        }
        catch (SQLException e){} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(con!=null)
            {
                try {
                    con.close();
                }
                catch (Exception e){}
            }
        }
        return userList;
    }

    public void delete(int id) {
        String sql = "delete from music where id=?";
        try
        {
            Connection con = DBUtil.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1,id);
            pr.executeUpdate();
        }
        catch (SQLException e)
        {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally
        {
            if(con!=null)
            {
                try
                {
                    con.close();
                }
                catch (Exception e){}
            }

        }

    }

    public void update(User user) {
        String sql = "update music set fname=?,lname=?,email=? where id=?";
        try
        {
            con=DBUtil.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1,user.getFirstName());
            pr.setString(2,user.getLastName());
            pr.setString(3,user.getEmail());
            pr.setInt(4,user.getId());
            pr.executeUpdate();




        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally
        {

            if(con!=null)
            {
                try
                {
                  con.close();
                }
                catch (Exception e){}
            }
        }
    }
}
