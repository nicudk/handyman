package ro.itschool.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.itschool.exception.CustomException;
import ro.itschool.service.OrderService;
import ro.itschool.service.UserService;
import ro.itschool.util.Constants;
@Getter
@Setter


    @Controller
    public class OrderController {

        @Autowired
        private OrderService orderService;

        @Autowired
        private UserService userService;


        //--------------SAVE DATA FROM MODAL (NEW BANK ACCOUNT)-------------------De facut new order
//        @GetMapping("/modals/add-bank-account")
//        public String addAccount(Model model) {
//            BankAccount bankAccount = new BankAccount();
//            model.addAttribute("account", bankAccount);
//            model.addAttribute("iban", bankAccount.getIban());
//            return "add-account-modal";
//        }
//
//        @PostMapping("/modals/add-bank-account")
//        public String addAccount(@ModelAttribute BankAccount account) {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            account.setUser(userService.findUserByUserName(auth.getName()));
//            accountService.save(account);
//            return Constants.REDIRECT_TO_INDEX;
//        }

        //----------------------------------------------------------------------------------

//        //--------------TRANSFER MONEY (MODAL)------------------------------
//        @GetMapping("/modals/transfer-money")
//        public String transferMoney(Model model) {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            final Long userId = userService.findUserByUserName(auth.getName()).getId();
//            model.addAttribute("accounts", accountService.getAllAccountsByUserId(userId));
//            model.addAttribute("transferMoneyRequest", new TransferMoneyRequest());
//            return "transfer-money-modal";
//        }
//
//        @PostMapping("/modals/transfer-money")
//        public String transferMoney(@ModelAttribute TransferMoneyRequest transferMoneyRequest) {
//            try {
//                accountService.transferMoney(transferMoneyRequest);
//            } catch (NotEnoughMoneyInAccount e) {
//                return "not-enough-money";
//            }
//            return Constants.REDIRECT_TO_INDEX;
//        }
//
//        //----------------------------------------------------------------------------------
//
//        //-------------------PAY A BILL-----------------------------------------------------
//        @GetMapping("/modals/pay-a-bill")
//        public String payABill(Model model) {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            final Long userId = userService.findUserByUserName(auth.getName()).getId();
//            model.addAttribute("accounts", accountService.getAllAccountsByUserId(userId));
//            model.addAttribute("payABill", new TransferMoneyRequest());
//            return "pay-a-bill-modal";
//        }
//
//        @PostMapping("/modals/pay-a-bill")
//        public String payABill(@ModelAttribute TransferMoneyRequest payABill) {
//            try {
//                accountService.payABill(payABill);
//            } catch (NotEnoughMoneyInAccount e) {
//                return "not-enough-money";
//            }
//            return Constants.REDIRECT_TO_INDEX;
//        }
        //----------------------------------------------------------------------------------

        //-------------------DELETE Order BY ID-------------------------------------------
//
//        @RequestMapping(value = "/order/delete/{id}")
//        public String deleteOrder(@PathVariable Long id) {
//            try {
//                OrderService.deleteById(id);
//            } catch (CustomException e) {
//                return "amount-not-empty";
//            }
//            return Constants.REDIRECT_TO_INDEX;
//        }

        //----------------------------------------------------------------------

    }


