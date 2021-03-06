package com.epam.command;

import com.epam.db.DBException;
import com.epam.db.UserRepository;
import com.epam.db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookTicketCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String address = "bookTicket.jsp";
        User user = new UserRepository().getByLogin(req.getParameter("loggedUser"));
        System.out.println(user);
        HttpSession session = req.getSession();
        session.setAttribute("loggedUser", user);
        System.out.println(session);
        return address;
    }

    @Override
    public String toString() {
        return "BookTicket";
    }
}
